package com.example.ad_book.model;

public class Usuario {

    private String nome;
    private String email;
    private String endereco;
    private String categoria;
    private String telefone;
    private int imagem;

    public Usuario(String nome, String email, String endereco, String categoria, String telefone, int imagem) {
        this.nome = nome;
        this.email = email;
        this.endereco = endereco;
        this.categoria = categoria;
        this.telefone = telefone;
        this.imagem = imagem;
    }

    public Usuario(){

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public int getImagem() {
        return imagem;
    }

    public void setImagem(int imagem) {
        this.imagem = imagem;
    }
}
