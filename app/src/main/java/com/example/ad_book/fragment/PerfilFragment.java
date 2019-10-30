package com.example.ad_book.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.ad_book.R;
import com.example.ad_book.activity.LoginActivity;

public class PerfilFragment extends Fragment {

    public static PerfilFragment newInstance(){
        return new PerfilFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_perfil, container, false);
        return view;
    }

    public void onClickSair(View view) {
        Intent intent = new Intent(view.getContext(), LoginActivity.class );
        startActivity(intent);
    }




}
