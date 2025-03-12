package com.jchallak.tdd.movieflix.services;

import com.jchallak.tdd.movieflix.dto.ReviewDTO;
import com.jchallak.tdd.movieflix.dto.UserDTO;
import com.jchallak.tdd.movieflix.entities.Movie;
import com.jchallak.tdd.movieflix.entities.Review;
import com.jchallak.tdd.movieflix.entities.User;
import com.jchallak.tdd.movieflix.repositories.MovieRepository;
import com.jchallak.tdd.movieflix.repositories.ReviewRepository;
import com.jchallak.tdd.movieflix.repositories.UserRepository;
import com.jchallak.tdd.movieflix.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ReviewRepository reviewRepository;

    @Override
    @Transactional
    public ReviewDTO save(ReviewDTO reviewDTO) {
        Movie movie = movieRepository.findById(reviewDTO.getMovieId()).orElseThrow(() -> new ResourceNotFoundException("There is not movie with id " + reviewDTO.getMovieId()));

        UserDTO userDTO = userService.getProfile();
        User user = userRepository.findByEmail(userDTO.getEmail());

        Review review = new Review();
        review.setText(reviewDTO.getText());
        review.setMovie(movie);
        review.setUser(user);
        movie.addReviews(review);

        Review review1 = reviewRepository.save(review);

        reviewDTO.setId(review.getId());
        reviewDTO.setUserEmail(review1.getUser().getEmail());
        reviewDTO.setUserName(review1.getUser().getUsername());
        reviewDTO.setUserId(review1.getUser().getId());
        return reviewDTO;
    }


}
