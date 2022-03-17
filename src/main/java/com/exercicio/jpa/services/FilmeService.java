package com.exercicio.jpa.services;

import java.util.List;
import java.util.Optional;

import com.exercicio.jpa.model.Filme;
import com.exercicio.jpa.repository.FilmeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FilmeService implements ServiceInterface<Filme>
{
    @Autowired
    private FilmeRepository filmeRepository;

    @Override
    public List<Filme> findAll()
    {
        return filmeRepository.findAll();
    }

    @Override
    public Filme findById(Long id)
    {
        Optional<Filme> filme = filmeRepository.findById(id);

        if(!filme.isPresent())
        {
            return null;
        }

        return filme.get();
    }

    public Filme create(Filme filme)
    {
        return filmeRepository.save(filme);
    }

    public boolean update(Filme filme)
    {
        if(!filmeRepository.existsById(filme.getId()))
        {
            return false;
        }

        filmeRepository.save(filme);

        return true;
    }

    @Override
    public boolean delete(Long id)
    {
        if(!filmeRepository.existsById(id))
        {
            return false;
        }

        filmeRepository.deleteById(id);

        return true;
    }
}
