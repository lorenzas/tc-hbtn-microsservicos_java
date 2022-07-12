package com.example.jpah2demo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

@Entity
public class Cliente implements Serializable {
    private static final long serialVersionUID = 4653634568329120484L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private int idade;
    private String email;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "cliente_id", referencedColumnName = "id")
    private Set<Telefone> telefones = new TreeSet<>();
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "cliente_id", referencedColumnName = "id")
    private Set<Endereco> enderecos = new TreeSet<>();

    public Cliente() {
    }

    public Cliente(Long id, String nome, int idade, String email, Set<Telefone> telefones, Set<Endereco> enderecos) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.email = email;
        this.telefones = telefones;
        this.enderecos = enderecos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Set<Telefone> getTelefones() {
        return telefones;
    }

    public void setTelefones(Set<Telefone> telefones) {
        this.telefones = telefones;
    }

    public Set<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(Set<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return getIdade() == cliente.getIdade() && getId().equals(cliente.getId()) && getNome().equals(cliente.getNome()) && getEmail().equals(cliente.getEmail()) && Objects.equals(getTelefones(), cliente.getTelefones()) && Objects.equals(getEnderecos(), cliente.getEnderecos());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNome(), getIdade(), getEmail(), getTelefones(), getEnderecos());
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", idade=" + idade +
                ", email='" + email + '\'' +
                ", telefones=" + telefones +
                ", enderecos=" + enderecos +
                '}';
    }
}
