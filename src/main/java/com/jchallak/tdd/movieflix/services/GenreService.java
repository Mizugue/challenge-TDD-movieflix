package com.jchallak.tdd.movieflix.services;



import com.jchallak.tdd.movieflix.dto.GenreDTO;


import java.util.List;

public interface GenreService {
    List<GenreDTO> findAll();
}
