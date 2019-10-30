package com.example.ad_book.activity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.ad_book.R;

public class CadastroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        ActionBar acb = getSupportActionBar();
        if(acb != null){
            acb.hide();
        }
    }

    public void onClickCadastrar(View view) {
        if (view.getId() == R.id.button_Cadastrar){
            Intent intent = new Intent(this, RecuperarSenhaActivity.class );
            startActivity(intent);
        }
    }
}
