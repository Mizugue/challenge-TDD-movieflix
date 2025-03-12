package com.jchallak.tdd.movieflix.repositories;

import com.jchallak.tdd.movieflix.entities.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Long> {
}
