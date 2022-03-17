package com.exercicio.jpa.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Nacionalidade extends AbstractEntity
{
    @Column(name = "nacionalidade", nullable = false,length = 50)
    private String pais;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "nacionalidade_id")
    private List<Ator> atores;

    public String getPais()
    {
        return this.pais;
    }

    public void setPais(String pais)
    {
        this.pais = pais;
    }
}
