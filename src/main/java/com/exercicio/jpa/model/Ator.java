package com.exercicio.jpa.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Ator extends AbstractEntity
{
    @Column(name = "nome_autor", nullable = false, length = 50)
    private String nome;

    @Column(name = "data_nascimento", nullable = false)
    private Date nascimento;

    @ManyToOne
    @JoinColumn(name = "nacionalidade_id")
    private Nacionalidade nacionalidade;

    @ManyToMany(mappedBy = "atores")
    private List<Filme> filmes;
    public void setNacionalidade(Nacionalidade nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public String getNome()
    {
        return this.nome;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }

    public Date getNascimento()
    {
        return this.nascimento;
    }

    public void setNascimento(Date nascimento)
    {
        this.nascimento = nascimento;
    }

    public Nacionalidade getNacionalidade()
    {
        return this.nacionalidade;
    }

    public List<Filme> getFilmes() {
        return this.filmes;
    }
}
