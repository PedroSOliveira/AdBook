package com.example.ad_book.model;

public class Anuncio {

    private String nomeAnuncio;
    private String descricao;
    private String endereco;
    private int imagem;

    public Anuncio(){

    }

    public Anuncio(String nomeAnuncio, String descricao, String endereco, int imagem) {
        this.nomeAnuncio = nomeAnuncio;
        this.descricao = descricao;
        this.endereco = endereco;
        this.imagem = imagem;
    }

    public String getNomeAnuncio() {
        return nomeAnuncio;
    }

    public void setNomeAnuncio(String nomeAnuncio) {
        this.nomeAnuncio = nomeAnuncio;
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

    public int getImagem() {
        return imagem;
    }

    public void setImagem(int imagem) {
        this.imagem = imagem;
    }
}
