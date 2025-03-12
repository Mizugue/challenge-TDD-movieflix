package com.jchallak.tdd.movieflix.controllers;

import com.jchallak.tdd.movieflix.dto.ReviewDTO;
import com.jchallak.tdd.movieflix.services.ReviewService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @PreAuthorize("hasAnyRole('MEMBER')")
    @PostMapping
    public ResponseEntity<ReviewDTO> insert(@Valid @RequestBody ReviewDTO reviewDTO){
        return new ResponseEntity<>(reviewService.save(reviewDTO), HttpStatus.CREATED);
    }

}
