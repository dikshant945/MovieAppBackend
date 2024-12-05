package dev.dikshant.movieApp.Controller;

import java.util.Map;

import dev.dikshant.movieApp.Dtos.Review;
import dev.dikshant.movieApp.Service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/reviews")
//@CrossOrigin(origins = "http://localhost:8080")
public class ReviewController {
    @Autowired
    ReviewService reviewService;

    @PostMapping
    public ResponseEntity<Review> createReview(@RequestBody Map<String, String> payload) {
        Review review = reviewService.createReview(payload.get("body"), payload.get("imdbId"));
        return new ResponseEntity<>(review, HttpStatus.CREATED);
    }

}
