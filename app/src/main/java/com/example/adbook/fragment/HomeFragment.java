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
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.adbook.activity.CadastrarAnuncioActivity;
import com.example.adbook.activity.FiltroActivity;
import com.example.adbook.R;
import com.example.adbook.activity.RotasActivity;
import com.example.adbook.adapter.AnuncioAdapter;
import com.example.adbook.adapter.UsuarioAdapter;
import com.example.adbook.model.Anuncio;
import com.example.adbook.model.Usuario;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment implements AnuncioAdapter.OnAnuncioListener{

    private RecyclerView recyclerView;
    private DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();


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

        // Configurar recycle view

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        fetchAds();

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

    @Override
    public void onAnuncioClick(int position, Anuncio anuncio) {


        Intent intent = new Intent(getContext(), RotasActivity.class);
        Bundle bundle = new Bundle();
        intent.putExtras(bundle);
        startActivity(intent);
    }

    private void fetchAds(){
        DatabaseReference ad = mDatabase.child("ad");

        ad.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                List<Anuncio> ad = new ArrayList<>();

                for (DataSnapshot nameSnapshot : dataSnapshot.getChildren()) {
                    ad.add(new Anuncio(nameSnapshot.getValue(Anuncio.class)));
                }

                AnuncioAdapter adapter = new AnuncioAdapter(getContext(), HomeFragment.this );
                adapter.addAnuncios(ad);
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
