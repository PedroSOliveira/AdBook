package com.example.ad_book.activity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.ad_book.R;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ActionBar acb = getSupportActionBar();

        if(acb != null){
            acb.hide();
        }


    }

    public void onClickEntrar(View view) {
        if (view.getId() == R.id.button_entrar){
            Intent intent = new Intent(this, MainActivity.class );
            startActivity(intent);
            overridePendingTransition(R.anim.res_anim_fadein, R.anim.res_anim_fadeout);

        }
    }

    public void onClickCadastrar(View view) {
        if (view.getId() == R.id.textViewCadastro){
            Intent intent = new Intent(this, CadastroActivity.class );
            startActivity(intent);
            overridePendingTransition(R.anim.res_anim_fadein, R.anim.res_anim_fadeout);
        }
    }

    public void onClickRecuperarSenha(View view) {
        if (view.getId() == R.id.textViewEsqueciSenha){
            Intent intent = new Intent(this, RecuperarSenhaActivity.class );
            startActivity(intent);
            overridePendingTransition(R.anim.res_anim_fadein, R.anim.res_anim_fadeout);
        }
    }

}
