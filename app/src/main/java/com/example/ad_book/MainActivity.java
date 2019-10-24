package com.example.ad_book;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void onClickEntrar(View view) {
        if (view.getId() == R.id.button_entrar){
            Intent intent = new Intent(this, CadastroActivity.class );
            startActivity(intent);
        }
    }

    public void onClickCadastrar(View view) {
        if (view.getId() == R.id.textViewCadastro){
            Intent intent = new Intent(this, CadastroActivity.class );
            startActivity(intent);
        }
    }

    public void onClickRecuperarSenha(View view) {
        if (view.getId() == R.id.textViewEsqueciSenha){
            Intent intent = new Intent(this, RecuperarSenhaActivity.class );
            startActivity(intent);
        }
    }

}
