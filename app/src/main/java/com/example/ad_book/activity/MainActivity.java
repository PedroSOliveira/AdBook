package com.example.ad_book.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.ad_book.R;
import com.example.ad_book.fragment.GeolocalizadorFragment;
import com.example.ad_book.fragment.HomeFragment;
import com.example.ad_book.fragment.PerfilFragment;
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
                        acb.setTitle("PerfilActivity");
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
}
