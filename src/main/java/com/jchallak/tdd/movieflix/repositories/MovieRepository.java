package com.jchallak.tdd.movieflix.repositories;

import com.jchallak.tdd.movieflix.dto.MovieCardDTO;
import com.jchallak.tdd.movieflix.entities.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    Page<Movie> findByGenreId(Long genreId, Pageable pageable);
}
