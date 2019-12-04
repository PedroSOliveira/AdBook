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
import android.widget.Spinner;
import android.widget.Toast;

import com.example.adbook.R;
import com.example.adbook.model.Anuncio;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CadastrarAnuncioActivity extends AppCompatActivity {

    private DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();
    private FirebaseAuth mAuth = FirebaseAuth.getInstance();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_anuncio);

        ActionBar acb = getSupportActionBar();

        if(acb != null){
            acb.hide();
        }
    }

    public void onClickCadastrar(View view) {

        final Spinner categoria = findViewById(R.id.categoriaFiltro);
        final EditText nomeAnuncio = findViewById(R.id.editTextNomeAnuncio);
        final EditText endereco = findViewById(R.id.editTextEnderecoAnuncio);
        final EditText descricao = findViewById(R.id.editTextDescricao);
        final ProgressBar progressBar = findViewById(R.id.progressBar_anuncio);
        final Button btnCadastrar = findViewById(R.id.button_cadastrar_anuncio);

        if(nomeAnuncio.getText().toString().isEmpty() || endereco.getText().toString().isEmpty() || descricao.getText().toString().isEmpty()){

            Toast.makeText(getApplicationContext(), "Nenhum dos campos pode ser vazio..",
                    Toast.LENGTH_SHORT).show();

            return;
        }

        progressBar.setVisibility(View.VISIBLE);
        btnCadastrar.setVisibility(View.GONE);

        Anuncio ad = new Anuncio(nomeAnuncio.getText().toString(), categoria.getSelectedItem().toString(), descricao.getText().toString(), endereco.getText().toString(), "-4.9793673", "39.0565189",  R.drawable.ufcqx, mAuth.getCurrentUser().getUid() );

        mDatabase.child("ad").push().setValue(ad).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

                final Exception err = e;

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getApplicationContext(), "Erro: "+ err.getMessage(), Toast.LENGTH_SHORT);
                        progressBar.setVisibility(View.GONE);
                        btnCadastrar.setVisibility(View.VISIBLE);
                    }
                });
            }
        }).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getApplicationContext(), "Cadastro realizado com sucesso.", Toast.LENGTH_SHORT);
                        progressBar.setVisibility(View.GONE);
                        btnCadastrar.setVisibility(View.VISIBLE);
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                        overridePendingTransition(R.anim.res_anim_fadein, R.anim.res_anim_fadeout);
                    }
                });
            }
        });

    }
}
