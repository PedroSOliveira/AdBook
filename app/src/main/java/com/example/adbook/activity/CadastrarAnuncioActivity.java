package com.example.adbook.activity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.adbook.Database;
import com.example.adbook.R;
import com.example.adbook.model.Anuncio;
import com.google.android.gms.maps.model.LatLng;

public class CadastrarAnuncioActivity extends AppCompatActivity {

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

        Spinner categoria = findViewById(R.id.categoriaFiltro);
        EditText nomeAnuncio = findViewById(R.id.editTextNomeAnuncio);
        EditText endereco = findViewById(R.id.editTextEnderecoAnuncio);
        EditText descricao = findViewById(R.id.editTextDescricao);

        Anuncio a = new Anuncio(nomeAnuncio.getText().toString(), categoria.getSelectedItem().toString(), descricao.getText().toString(), endereco.getText().toString(), new LatLng(-4.9793673, -39.0565189), R.drawable.ufcqx);
        Database.addAnuncio(a);
        Intent intent = new Intent(this, MainActivity.class );
        startActivity(intent);
        overridePendingTransition(R.anim.res_anim_fadein, R.anim.res_anim_fadeout);

    }
}
