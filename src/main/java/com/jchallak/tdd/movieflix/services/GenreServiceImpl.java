package com.jchallak.tdd.movieflix.services;

import com.jchallak.tdd.movieflix.dto.GenreDTO;
import com.jchallak.tdd.movieflix.repositories.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreServiceImpl implements GenreService{

    @Autowired
    private GenreRepository repository;

    @Override
    public List<GenreDTO> findAll() {
        return repository.findAll().stream().map(GenreDTO::new).toList();
    }
}
