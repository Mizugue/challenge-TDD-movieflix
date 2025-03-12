package com.jchallak.tdd.movieflix.controllers;

import com.jchallak.tdd.movieflix.dto.MovieCardDTO;
import com.jchallak.tdd.movieflix.dto.MovieDetailsDTO;
import com.jchallak.tdd.movieflix.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<MovieDetailsDTO> findById(@PathVariable Long id){
        return new ResponseEntity<>(movieService.findById(id), HttpStatus.OK);

    }

    @GetMapping
    public ResponseEntity<Page<MovieCardDTO>> findByGenre(
            @RequestParam(required = false) Long genreId,
            @PageableDefault(sort = "title", direction = Sort.Direction.ASC) Pageable pageable) {
        return ResponseEntity.ok(movieService.findByGenre(genreId, pageable));
    }



}
