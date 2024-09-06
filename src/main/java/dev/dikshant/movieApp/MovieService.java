package dev.dikshant.movieApp;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;
    public List<Movie> allMovies()  {
      return movieRepository.findAll();
    }

    public Optional<Movie> fetchMovie(ObjectId movieId) {
      return movieRepository.findById(movieId);
    }

    public Optional<Movie> fetchMovieByImdb(String imdbId) {
        return movieRepository.findMoviesByImdbId(imdbId);
    }

    public Optional<Movie> fetchMovieByTitle(String title) {
        return movieRepository.findMoviesByTitle(title);
    }


}
