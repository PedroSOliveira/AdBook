package com.example.adbook.activity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.adbook.Database;
import com.example.adbook.R;
import com.example.adbook.model.Usuario;

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


        EditText nome = findViewById(R.id.nomeUser);
        EditText email = findViewById(R.id.emailUser);
        EditText senha = findViewById(R.id.senhauser);

        Usuario u = new Usuario(nome.getText().toString(), email.getText().toString(),  senha.getText().toString() );

        Database.addUsuario(u);
        new Database().teste(nome.getText().toString());

        Intent intent = new Intent(this, LoginActivity.class );
        startActivity(intent);

    }
}
