package com.example.adbook.model;

public class Usuario {

    private String nome;
    private String senha;
    private String email;
    private String endereco;
    private String categoria;
    private String telefone;
    private String avatar;

    public Usuario(String nome, String email){
        this.nome = nome;
        this.email = email;
        this.endereco = "";
        this.categoria = "";
        this.telefone = "";
        this.avatar = "";
    }

    public Usuario(String nome, String email, String endereco, String categoria, String telefone, String avatar) {
        this.nome = nome;
        this.email = email;
        this.endereco = endereco;
        this.categoria = categoria;
        this.telefone = telefone;
        this.avatar = avatar;
    }

    public Usuario(){

    }

    public Usuario(Usuario value) {
        this.nome = value.getNome();
        this.email = value.getEmail();
        this.endereco = value.getEndereco();
        this.categoria = value.getEndereco();
        this.telefone = value.getEndereco();
        this.avatar = value.getAvatar();
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
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

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
