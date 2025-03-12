package com.jchallak.tdd.movieflix.services;

import com.jchallak.tdd.movieflix.dto.MovieCardDTO;
import com.jchallak.tdd.movieflix.dto.MovieDetailsDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MovieService {
    MovieDetailsDTO findById(Long id);
    Page<MovieCardDTO> findByGenre(Long genreId, Pageable pageable);
}
