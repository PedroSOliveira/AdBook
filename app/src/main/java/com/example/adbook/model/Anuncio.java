package com.example.adbook.model;

import com.google.android.gms.maps.model.LatLng;

public class Anuncio {

    private String nomeAnuncio;
    private String categoria;
    private String descricao;
    private String endereco;
    private LatLng latLng;
    private int imagem;

    public Anuncio(){

    }

    public Anuncio(String nomeAnuncio, String categoria, String descricao, String endereco, LatLng latLng, int imagem) {
        this.nomeAnuncio = nomeAnuncio;
        this.categoria = categoria;
        this.descricao = descricao;
        this.endereco = endereco;
        this.latLng = latLng;
        this.imagem = imagem;
    }

    public String getNomeAnuncio() {
        return nomeAnuncio;
    }

    public void setNomeAnuncio(String nomeAnuncio) {
        this.nomeAnuncio = nomeAnuncio;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public LatLng getLatLng() {
        return latLng;
    }

    public void setLatLng(LatLng latLng) {
        this.latLng = latLng;
    }

    public int getImagem() {
        return imagem;
    }

    public void setImagem(int imagem) {
        this.imagem = imagem;
    }
}
