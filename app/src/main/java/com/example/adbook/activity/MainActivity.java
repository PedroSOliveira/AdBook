package com.example.adbook.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.example.adbook.R;
import com.example.adbook.fragment.GeolocalizadorFragment;
import com.example.adbook.fragment.HomeFragment;
import com.example.adbook.fragment.PerfilFragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {


    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        final ActionBar acb = getSupportActionBar();

        mudarFragment(HomeFragment.newInstance());
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_home:
                        mudarFragment(HomeFragment.newInstance());
                        acb.setTitle("AdBook");
                        return true;
                    case R.id.menu_geolocalizador:
                        mudarFragment(GeolocalizadorFragment.newInstance());
                        acb.setTitle("Geolocalizador");
                        return true;
                    case R.id.menu_perfil:
                        mudarFragment(PerfilFragment.newInstance());
                        acb.setTitle("Perfil");
                        return true;
                }

                return false;
            }
        });
    }


    private void mudarFragment(Fragment fragment){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame, fragment);
        transaction.commit();
    }

    private void init(){
       bottomNavigationView = findViewById(R.id.bottomNavigation);

    }

    public void onClickSair(View view) {

            Intent intent = new Intent(this, LoginActivity.class );
            startActivity(intent);
            overridePendingTransition(R.anim.res_anim_fadein, R.anim.res_anim_fadeout);
    }
}
