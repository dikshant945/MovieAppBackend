package dev.dikshant.movieApp.Service;

import java.util.List;
import java.util.Optional;

import dev.dikshant.movieApp.Dtos.Movie;
import dev.dikshant.movieApp.Dtos.MovieRequest;
import dev.dikshant.movieApp.Dtos.MovieResponse;
import dev.dikshant.movieApp.Repositories.MovieRepository;
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

    public Optional<MovieResponse> addMovie(MovieRequest movieRequest){
        Movie newMovie = new Movie();
        newMovie.setImdbId(movieRequest.getImdbId());
        newMovie.setBackdrops(movieRequest.getBackdrops());
        newMovie.setGenres(movieRequest.getGenres());
        newMovie.setTrailerLink(movieRequest.getTrailerLink());

        Movie savedMovie = movieRepository.save(newMovie);

        MovieResponse movieResponse = new MovieResponse();
        movieResponse.setImdbId(savedMovie.getImdbId());

        return Optional.of(movieResponse);
    }


}
