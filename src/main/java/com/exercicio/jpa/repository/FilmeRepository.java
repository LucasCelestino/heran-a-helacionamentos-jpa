package com.exercicio.jpa.repository;

import com.exercicio.jpa.model.Filme;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmeRepository extends JpaRepository<Filme, Long>{}
