package br.ifsc.edu.br.firebase;

public class Usuario {
    private String id;
    private String nome;
    private int idade;
    private String email;

    public Usuario(String id, String nome, int idade, String email)
    {
        this.setId(id);
        this.setNome(nome);
        this.setIdade(idade);
        this.setEmail(email);
    }

    public Usuario()
    {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
