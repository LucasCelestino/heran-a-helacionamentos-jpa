package com.exercicio.jpa.controllers;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import com.exercicio.jpa.model.Filme;
import com.exercicio.jpa.services.FilmeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/filmes")
public class FilmeController implements ControllerInterface<Filme>
{

    @Autowired
    private FilmeService filmeService;

    @Override
    @GetMapping
    public ResponseEntity<List<Filme>> getAll()
    {
        return ResponseEntity.status(HttpStatus.OK).body(filmeService.findAll());
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable("id") Long id)
    {
        Filme filme = filmeService.findById(id);

        if(filme != null)
        {
            return ResponseEntity.status(HttpStatus.OK).body(filme);
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @Override
    @PostMapping
    public ResponseEntity<Filme> post(@RequestBody Filme filme) throws URISyntaxException
    {
        filmeService.create(filme);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(filme.getId())
			           .toUri();

        return ResponseEntity.created(location).body(filme);
    }

    @Override
    @PutMapping
    public ResponseEntity<?> put(@RequestBody Filme filme)
    {
        if (filmeService.update(filme))
        {
			return ResponseEntity.status(HttpStatus.OK).body(filme);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id)
    {
        if(filmeService.delete(id))
        {
            return ResponseEntity.status(HttpStatus.OK).build();
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
    
}
