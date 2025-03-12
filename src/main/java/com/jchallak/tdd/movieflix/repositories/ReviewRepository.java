package com.jchallak.tdd.movieflix.repositories;

import com.jchallak.tdd.movieflix.entities.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
}
