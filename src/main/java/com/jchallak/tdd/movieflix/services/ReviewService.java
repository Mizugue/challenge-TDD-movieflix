package com.jchallak.tdd.movieflix.services;

import com.jchallak.tdd.movieflix.dto.ReviewDTO;

public interface ReviewService {
    ReviewDTO save(ReviewDTO reviewDTO);
}
