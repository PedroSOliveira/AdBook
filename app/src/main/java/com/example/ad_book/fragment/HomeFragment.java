package com.example.ad_book.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ad_book.activity.CadastrarAnuncioActivity;
import com.example.ad_book.activity.FiltroActivity;
import com.example.ad_book.R;
import com.example.ad_book.adapter.AnuncioAdapter;
import com.example.ad_book.model.Anuncio;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment implements View.OnClickListener {

    private RecyclerView recyclerView;
    private List<Anuncio> anuncios = new ArrayList<>();

    public static HomeFragment newInstance(){
        return new HomeFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        recyclerView = view.findViewById(R.id.rvHome);

        this.criarAnuncio();

        // Configurar Adapter

        AnuncioAdapter anuncioAdapter = new AnuncioAdapter(anuncios);

        // Configurar recycle view

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(anuncioAdapter);

        // evento click

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Click", Toast.LENGTH_LONG).show();
            }
        });


        return view;
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.toolbar_home, menu);
        menu.findItem(R.id.menu_home_mapa).setVisible(false);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent intent = null ;
         switch (item.getItemId()){
             case R.id.menu_home_add_anuncio:
                  intent = new Intent(getContext(), CadastrarAnuncioActivity.class );
                 startActivity(intent);
                 //overridePendingTransition(R.anim.res_anim_fadein, R.anim.res_anim_fadeout);
                 return true;
             case R.id.menu_home_filtro:
                 intent = new Intent(getContext(), FiltroActivity.class );
                 startActivity(intent);
                 return true;
             default:
                 return true;
         }
    }

    private void criarAnuncio(){

        Anuncio a = new Anuncio("Empreenday", "Evento na UFC quixadá", "Endereco da ufc", R.drawable.ufcqx );
        anuncios.add(a);
        anuncios.add(a);
        anuncios.add(a);
        anuncios.add(a);
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(getContext(), "Click", Toast.LENGTH_LONG).show();
    }
}
