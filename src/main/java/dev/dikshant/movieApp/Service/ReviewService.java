package dev.dikshant.movieApp.Service;

import java.util.ArrayList;
import java.util.Optional;

import dev.dikshant.movieApp.Dtos.Movie;
import dev.dikshant.movieApp.Dtos.Review;
import dev.dikshant.movieApp.Repositories.MovieRepository;
import dev.dikshant.movieApp.Repositories.ReviewRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ReviewService {
    @Autowired
    ReviewRepository reviewRepository;

    @Autowired
    private MovieRepository movieRepository;

    @Autowired MongoTemplate mongoTemplate;

    public Review createReview(String reviewBody, String imdbId) {
        Review review = reviewRepository.insert(new Review(reviewBody, imdbId));
        reviewRepository.save(review);
        Optional<Movie> optionalMovie = movieRepository.findMoviesByImdbId(imdbId);
        if(optionalMovie.isEmpty()) {
            System.out.println("Unable to find the movie with this imdbId");
            throw  new RuntimeException();
        }

        Movie movie = optionalMovie.get();
        if (movie.getReviewIds() == null) {
            movie.setReviewIds(new ArrayList<>());
        }
        movie.getReviewIds().add(review.getId());
        movieRepository.save(movie);
        return review;
    }
}
