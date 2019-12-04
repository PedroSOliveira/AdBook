package com.example.adbook.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.adbook.activity.FiltroActivity;
import com.example.adbook.R;
import com.example.adbook.activity.RotasActivity;
import com.example.adbook.adapter.UsuarioAdapter;
import com.example.adbook.model.Usuario;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class GeolocalizadorFragment extends Fragment {

    private RecyclerView recyclerView;
    private DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();


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
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        fetchUsers();

        return view;
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.toolbar_home, menu);
        menu.findItem(R.id.menu_home_add_anuncio).setVisible(false);
        menu.findItem(R.id.menu_home_mapa).setVisible(false);
        menu.findItem(R.id.menu_home_filtro).setVisible(false);
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

    private void fetchUsers(){
        DatabaseReference users = mDatabase.child("users");



        users.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                List<Usuario> users = new ArrayList<>();

                for (DataSnapshot nameSnapshot : dataSnapshot.getChildren()) {
                    users.add(new Usuario(nameSnapshot.getValue(Usuario.class)));
                }

                UsuarioAdapter adapter = new UsuarioAdapter(getContext());
                adapter.addUsuarios(users);
                adapter.notifyDataSetChanged();
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getContext(), "Erro: "+ databaseError.getMessage(), Toast.LENGTH_SHORT);
            }
        });
    }
}
