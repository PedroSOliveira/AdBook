package com.example.adbook;

import android.util.Log;

import androidx.annotation.NonNull;

import com.example.adbook.model.Anuncio;
import com.example.adbook.model.Usuario;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static android.content.ContentValues.TAG;

public class Database {

    // Access a Cloud Firestore instance from your Activity
    private Fire





    private static final List<Anuncio> dbAnuncio = new ArrayList<>();
    private static final List<Anuncio> dbFiltrado = new ArrayList<>();

    private static final List<Usuario> dbUsuarios = new ArrayList<>();

    public static List<Anuncio> getDbAnuncio() {
        return dbFiltrado;
    }

    public static List<Usuario> getDbUsuarios() {
        return dbUsuarios;
    }


    public static void addAnuncio(Anuncio anuncio){
        dbAnuncio.add(anuncio);
        dbFiltrado.add(anuncio);
    }

    public void teste(String name){
        // Create a new user with a first and last name
        Map<String, Object> user = new HashMap<>();
        user.put("first", name);

// Add a new document with a generated ID
        db.collection("users")
                .add(user)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Log.d(TAG, "DocumentSnapshot added with ID: " + documentReference.getId());
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(TAG, "Error adding document", e);
                    }
                });

    }

    public static void addUsuario(Usuario usuario){
        dbUsuarios.add(usuario);
    }


    public static Anuncio getAnuncio(String nomeAnuncio){
        for(Anuncio a : dbAnuncio) {
            if(a.getNomeAnuncio().equalsIgnoreCase(nomeAnuncio)){
                return a;
            }
        }
        return null;
    }

    public static boolean validaUsuario(String usuario, String senha){
        for(Usuario u : dbUsuarios) {
            if(u.getEmail().equalsIgnoreCase(usuario) && u.getSenha().equals(senha)){
                return true;
            }
        }
        return false;
    }

    public static void filtrarAnuncios(String categoria){
        dbFiltrado.clear();

        if(categoria.equalsIgnoreCase("Todos")){

            dbFiltrado.addAll(dbAnuncio);

            return;
        }

        for(Anuncio a : dbAnuncio){
            if(a.getCategoria().equalsIgnoreCase(categoria)){
                dbFiltrado.add(a);
            }
        }

    }

}
