package com.example.adbook.model;

import com.google.android.gms.maps.model.LatLng;

public class Anuncio {

    private String anuncianteUID;
    private String nomeAnuncio;
    private String categoria;
    private String descricao;
    private String endereco;
    private String latitude;
    private String longitude;
    private int imagem;

    public Anuncio(){

    }

    public Anuncio(String nomeAnuncio, String categoria, String descricao, String endereco, String latitude, String longitude, int imagem, String uid) {
        this.anuncianteUID = uid;
        this.nomeAnuncio = nomeAnuncio;
        this.categoria = categoria;
        this.descricao = descricao;
        this.endereco = endereco;
        this.latitude = latitude;
        this.latitude = longitude;
        this.imagem = imagem;
    }

    public Anuncio(Anuncio value) {
        this.anuncianteUID = value.getUid();
        this.nomeAnuncio = value.getNomeAnuncio();
        this.categoria = value.getCategoria();
        this.descricao = value.getDescricao();
        this.endereco = value.getEndereco();
        this.longitude = value.getLongitude();
        this.latitude = value.getLatitude();
        this.imagem = value.getImagem();
    }

    public String getUid() {
        return anuncianteUID;
    }

    public void setUid(String uid) {
        this.anuncianteUID = uid;
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

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public int getImagem() {
        return imagem;
    }

    public void setImagem(int imagem) {
        this.imagem = imagem;
    }
}
