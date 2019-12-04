package com.example.adbook.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
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
import com.google.firebase.auth.FirebaseAuth;

public class RecuperarSenhaActivity extends AppCompatActivity {

    private FirebaseAuth mAuth = FirebaseAuth.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recuperar_senha);

        ActionBar acb = getSupportActionBar();
        if (acb != null) {
            acb.hide();
        }
    }

    public void recuperarSenha(View view) {

        final EditText edtEmail = findViewById(R.id.edt_txt_recuperar_senha_email);
        final Button btnRecuperarSenha = findViewById(R.id.button_recuperar_senha);
        final ProgressBar progressBar = findViewById(R.id.progress_bar_recuperar_senha);
        final TextView txtVoltar = findViewById(R.id.txt_view_recuperar_senha_voltar);

        if(edtEmail.getText().toString().isEmpty()){

            Toast.makeText(getApplicationContext(), "Email não podem ser vazio.",
                    Toast.LENGTH_LONG).show();

            return;
        }

        btnRecuperarSenha.setVisibility(View.GONE);
        txtVoltar.setVisibility(View.GONE);
        progressBar.setVisibility(View.VISIBLE);

        mAuth.sendPasswordResetEmail(edtEmail.getText().toString()).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {
                    runOnUiThread(new Runnable() {
                        @SuppressLint("ShowToast")
                        @Override
                        public void run() {
                            btnRecuperarSenha.setVisibility(View.VISIBLE);
                            txtVoltar.setVisibility(View.VISIBLE);
                            progressBar.setVisibility(View.GONE);
                            Toast.makeText(getApplicationContext(), "Email enviado com sucesso. Acesse o seu email para continuar", Toast.LENGTH_LONG).show();
                        }
                    });
                } else {
                    final String erro = task.getException().getMessage();
                    runOnUiThread(new Runnable() {
                        @SuppressLint("ShowToast")
                        @Override
                        public void run() {
                            btnRecuperarSenha.setVisibility(View.VISIBLE);
                            txtVoltar.setVisibility(View.VISIBLE);
                            progressBar.setVisibility(View.GONE);
                            Toast.makeText(getApplicationContext(), "Erro: "+erro , Toast.LENGTH_LONG).show();
                        }
                    });
                }
            }
        });
    }

    public void voltar(View view){
        Intent intent = new Intent(this, LoginActivity.class );
        startActivity(intent);
        overridePendingTransition(R.anim.res_anim_fadein, R.anim.res_anim_fadeout);
    }
}
