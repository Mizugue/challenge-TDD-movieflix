package com.jchallak.tdd.movieflix.services;

import com.jchallak.tdd.movieflix.dto.MovieCardDTO;
import com.jchallak.tdd.movieflix.dto.MovieDetailsDTO;
import com.jchallak.tdd.movieflix.entities.Movie;
import com.jchallak.tdd.movieflix.repositories.MovieRepository;
import com.jchallak.tdd.movieflix.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class MovieServiceImpl implements MovieService{

    @Autowired
    private MovieRepository movieRepository;

    @Override
    public MovieDetailsDTO findById(Long id) {
        Movie movie = movieRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("There is not movie with id " + id));
        return new MovieDetailsDTO(movie);
    }

    @Override
    public Page<MovieCardDTO> findByGenre(Long genreId, Pageable pageable) {
        if (genreId == null) {
            return movieRepository.findAll(pageable).map(MovieCardDTO::new);
        }
        return movieRepository.findByGenreId(genreId, pageable).map(MovieCardDTO::new);
    }


}

