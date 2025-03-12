package com.jchallak.tdd.movieflix.controllers;

import com.jchallak.tdd.movieflix.dto.GenreDTO;
import com.jchallak.tdd.movieflix.services.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping(value = "/genres")
public class GenreController {

    @Autowired
    private GenreService service;

    @GetMapping
    public ResponseEntity<List<GenreDTO>> findAll(){
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);

    }







}
