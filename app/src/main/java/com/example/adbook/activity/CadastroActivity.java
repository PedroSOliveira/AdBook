package com.example.adbook.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.adbook.R;
import com.example.adbook.model.Usuario;


import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CadastroActivity extends AppCompatActivity {

    private FirebaseAuth mAuth = FirebaseAuth.getInstance();
    private DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        ActionBar acb = getSupportActionBar();
        if (acb != null) {
            acb.hide();
        }
    }

    public void onClickCadastrar(View view) {


        final EditText nome = findViewById(R.id.nomeUser);
        final EditText email = findViewById(R.id.emailUser);
        final EditText senha = findViewById(R.id.senhauser);
        final Button btnCadastrar = findViewById(R.id.button_Cadastrar);
        final ProgressBar progressBar = findViewById(R.id.progressBar);

        if(nome.getText().toString().isEmpty() || email.getText().toString().isEmpty() || senha.getText().toString().isEmpty()){

            Toast.makeText(getApplicationContext(), "Nenhum dos campos pode ser vazio..",
                    Toast.LENGTH_SHORT).show();

            return;
        }

        progressBar.setVisibility(View.VISIBLE);
        btnCadastrar.setVisibility(View.GONE);


        this.mAuth.createUserWithEmailAndPassword(email.getText().toString(), senha.getText().toString())
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            final FirebaseUser user = mAuth.getCurrentUser();

                            new Thread(new Runnable() {
                                @Override
                                public void run() {
                                    mDatabase.child("users").child(user.getUid()).setValue(new Usuario(
                                            nome.getText().toString(),
                                            email.getText().toString()
                                    )).addOnFailureListener(new OnFailureListener() {
                                        @Override
                                        public void onFailure(@NonNull Exception e) {

                                            final Exception err = e;

                                            runOnUiThread(new Runnable() {
                                                @Override
                                                public void run() {
                                                    progressBar.setVisibility(View.GONE);
                                                    btnCadastrar.setVisibility(View.VISIBLE);
                                                    Toast.makeText(getApplicationContext(), "Erro: "+ err.getMessage(), Toast.LENGTH_LONG);
                                                }
                                            });
                                        }
                                    }).addOnSuccessListener(new OnSuccessListener<Void>() {
                                        @Override
                                        public void onSuccess(Void aVoid) {
                                            runOnUiThread(new Runnable() {
                                                @Override
                                                public void run() {
                                                    progressBar.setVisibility(View.GONE);
                                                    btnCadastrar.setVisibility(View.VISIBLE);
                                                    Toast.makeText(getApplicationContext(), "Cadastro realizado com sucesso.", Toast.LENGTH_LONG);
                                                    Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                                                    startActivity(intent);
                                                }
                                            });
                                        }
                                    });
                                }
                            }).start();
                        } else {
                            Toast.makeText(getApplicationContext(), "Erro: "+task.getException().getMessage(),
                                    Toast.LENGTH_SHORT).show();
                        }

                    }
                });


        //Database.addUsuario(u);
        //new Database().teste(nome.getText().toString());


    }
}
