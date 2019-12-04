package com.example.adbook.activity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;

import com.example.adbook.R;

public class FiltroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filtro);

        ActionBar acb = getSupportActionBar();

        if(acb != null){
            acb.hide();
        }
    }

    public void onClickFiltrar(View view) {

        Spinner categoria = findViewById(R.id.categoriaFiltro);

        //Database.filtrarAnuncios(categoria.getSelectedItem().toString());
        Intent intent = new Intent(this, MainActivity.class );
        startActivity(intent);
        overridePendingTransition(R.anim.res_anim_fadein, R.anim.res_anim_fadeout);

    }
}
