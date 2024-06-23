package com.codefolio.backend.entidade;

public class Usuario {

    private String nome;
    private String email;
    private String telefone;
    private String comoConheceu;

    public Usuario(String nome, String email, String telefone, String comoConheceu) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.comoConheceu = comoConheceu;
    }

    public Usuario() {
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getComoConheceu() {
        return comoConheceu;
    }

}
