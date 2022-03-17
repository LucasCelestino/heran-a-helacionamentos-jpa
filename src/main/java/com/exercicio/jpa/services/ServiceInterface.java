package com.exercicio.jpa.services;

import java.util.List;

public interface ServiceInterface<T>
{
    List<T> findAll();
    T findById(Long id);
	boolean delete(Long id);
}
