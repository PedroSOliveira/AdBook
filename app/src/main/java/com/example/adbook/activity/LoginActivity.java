package com.example.adbook.activity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.adbook.Database;
import com.example.adbook.R;

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

        EditText login = findViewById(R.id.editTextLogin);
        EditText senha = findViewById(R.id.editTextSenha);

        boolean validaUsuario = Database.validaUsuario(login.getText().toString(), senha.getText().toString());

        if(validaUsuario){
            Intent intent = new Intent(this, MainActivity.class );
            startActivity(intent);
            overridePendingTransition(R.anim.res_anim_fadein, R.anim.res_anim_fadeout);
        }

    }

    public void onClickCadastrar(View view) {

            Intent intent = new Intent(this, CadastroActivity.class );
            startActivity(intent);
            overridePendingTransition(R.anim.res_anim_fadein, R.anim.res_anim_fadeout);

    }

    public void onClickRecuperarSenha(View view) {

            Intent intent = new Intent(this, RecuperarSenhaActivity.class );
            startActivity(intent);
            overridePendingTransition(R.anim.res_anim_fadein, R.anim.res_anim_fadeout);

    }


}
