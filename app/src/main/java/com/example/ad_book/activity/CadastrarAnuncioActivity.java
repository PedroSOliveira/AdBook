package com.example.ad_book.activity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.ad_book.R;

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
}
