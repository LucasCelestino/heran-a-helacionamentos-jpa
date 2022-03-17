package com.exercicio.jpa.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Filme extends AbstractEntity
{
    @Column(name = "titulo_filme", nullable = false, length = 50)
    private String titulo;

    @Column(name = "ano_lancamento", nullable = false)
    private Integer ano;

    @ManyToMany
    @JoinTable(name = "tb_filme_ator", joinColumns = @JoinColumn(name = "filme_id"), inverseJoinColumns = @JoinColumn(name = "ator_id"))
    private List<Ator> atores;

    public String getTitulo() {
        return this.titulo;
    }

    public void setTitulo(String titulo)
    {
        this.titulo = titulo;
    }

    public Integer getAno()
    {
        return this.ano;
    }

    public void setAno(Integer ano)
    {
        this.ano = ano;
    }

    public List<Ator> getAtores()
    {
        return this.atores;
    }

    public void setAtores(List<Ator> atores)
    {
        this.atores = atores;
    }
}
