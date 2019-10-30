package com.example.ad_book.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ad_book.activity.FiltroActivity;
import com.example.ad_book.R;
import com.example.ad_book.activity.RotasActivity;
import com.example.ad_book.adapter.UsuarioAdapter;
import com.example.ad_book.model.Usuario;

import java.util.ArrayList;
import java.util.List;

public class GeolocalizadorFragment extends Fragment {

    private RecyclerView recyclerView;
    private List<Usuario> usuarios = new ArrayList<>();

    public static GeolocalizadorFragment newInstance(){
        return new GeolocalizadorFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_geolocalizador, container, false);
        recyclerView = view.findViewById(R.id.rvGeolocalizador);

        this.criarUsuarios();

        UsuarioAdapter usuarioAdapter = new UsuarioAdapter(usuarios);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(usuarioAdapter);

        return view;
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.toolbar_home, menu);
        menu.findItem(R.id.menu_home_add_anuncio).setVisible(false);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        Intent intent = null;

        switch (item.getItemId()){
            case R.id.menu_home_filtro:
                intent = new Intent(getContext(), FiltroActivity.class );
                startActivity(intent);
                return true;
            case R.id.menu_home_mapa:
                intent = new Intent(getContext(), RotasActivity.class );
                startActivity(intent);
                return true;
            default:
                return true;
        }
    }

    private void criarUsuarios(){
        Usuario u = new Usuario("Pedro", "pedro@adbook.com.br", "Endereco do usuario, numero 77", "T.I", "88 9 9999 8888", R.drawable.user);
        usuarios.add(u);
        usuarios.add(u);
        usuarios.add(u);
        usuarios.add(u);
    }
}
