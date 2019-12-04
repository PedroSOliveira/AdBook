package com.example.adbook.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.adbook.R;
import com.example.adbook.model.Usuario;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class PerfilFragment extends Fragment {

    private FirebaseAuth mAuth = FirebaseAuth.getInstance();
    private DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();

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

        FirebaseUser currentUser = mAuth.getCurrentUser();
        DatabaseReference user = mDatabase.child("users").child(currentUser.getUid());

        final EditText edtEmail = view.findViewById(R.id.edt_txt_email_perfil);
        final EditText edtNome = view.findViewById(R.id.edt_txt_nome_perfil);
        final EditText edtCategoria = view.findViewById(R.id.edt_txt_categoria_perfil);

        edtEmail.setText(currentUser.getEmail());

        user.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Usuario usuario = new Usuario(dataSnapshot.getValue(Usuario.class));
                edtNome.setText(usuario.getNome());
                edtCategoria.setText(usuario.getCategoria());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        return view;
    }


    public void mudarSenha(View view){
        mAuth.sendPasswordResetEmail("").addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(getContext(), "Email enviado com sucesso. Acesse o seu email para continuar", Toast.LENGTH_SHORT).show();


                } else {
                    final String erro = task.getException().getMessage();
                    Toast.makeText(getContext(), "Erro: "+erro , Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}
