package com.example.adbook;

import com.example.adbook.model.Anuncio;
import com.example.adbook.model.Usuario;

import java.util.ArrayList;
import java.util.List;

public class Database {

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
