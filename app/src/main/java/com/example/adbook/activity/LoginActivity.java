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
import android.widget.TextView;
import android.widget.Toast;

import com.example.adbook.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {

    private FirebaseAuth mAuth = FirebaseAuth.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ActionBar acb = getSupportActionBar();

        if (acb != null) {
            acb.hide();
        }


    }

    public void onClickEntrar(View view) {

        final EditText edtLogin = findViewById(R.id.editTextLogin);
        final EditText edtSenha = findViewById(R.id.editTextSenha);
        final ProgressBar progressBar = findViewById(R.id.progressBarLogin);
        final Button btnLogin = findViewById(R.id.button_entrar);
        final TextView txtCadastrar = findViewById(R.id.textViewCadastro);
        final TextView txtRecuperarSenha = findViewById(R.id.textViewEsqueciSenha);



        if(edtLogin.getText().toString().isEmpty() || edtSenha.getText().toString().isEmpty()){

            Toast.makeText(getApplicationContext(), "Email ou senha não podem ser vazio.",
                    Toast.LENGTH_LONG).show();

            return;
        }


        btnLogin.setVisibility(View.GONE);
        txtCadastrar.setVisibility(View.GONE);
        txtRecuperarSenha.setVisibility(View.GONE);
        progressBar.setVisibility(View.VISIBLE);

        mAuth.signInWithEmailAndPassword(edtLogin.getText().toString(), edtSenha.getText().toString())
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful()) {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {

                                    btnLogin.setVisibility(View.VISIBLE);
                                    progressBar.setVisibility(View.GONE);
                                    txtCadastrar.setVisibility(View.VISIBLE);
                                    txtRecuperarSenha.setVisibility(View.VISIBLE);
                                    Toast.makeText(getApplicationContext(), "Autenticação realizada com sucesso.",
                                            Toast.LENGTH_SHORT).show();

                                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                    startActivity(intent);
                                    overridePendingTransitio
                                n(R.anim.res_anim_fadein, R.anim.res_anim_fadeout);
                                }
                            });
                        } else {

                            final String erro = task.getException().getMessage();
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {

                                    btnLogin.setVisibility(View.VISIBLE);
                                    txtCadastrar.setVisibility(View.VISIBLE);
                                    txtRecuperarSenha.setVisibility(View.VISIBLE);
                                    progressBar.setVisibility(View.GONE);
                                    Toast.makeText(getApplicationContext(), "Erro: " + erro,
                                            Toast.LENGTH_LONG).show();
                                }
                            });
                        }

                    }
                });
    }

    public void onClickCadastrar(View view) {

        Intent intent = new Intent(this, CadastroActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.res_anim_fadein, R.anim.res_anim_fadeout);

    }

    public void onClickRecuperarSenha(View view) {

        Intent intent = new Intent(this, RecuperarSenhaActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.res_anim_fadein, R.anim.res_anim_fadeout);

    }


}
