package dev.dikshant.movieApp.Controller;

import java.util.List;
import java.util.Optional;

import dev.dikshant.movieApp.Dtos.Movie;
import dev.dikshant.movieApp.Service.MovieService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;
    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovie(){
       return new ResponseEntity<List<Movie>>(movieService.allMovies(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Movie>> getMovie(@PathVariable ObjectId id) {
        return new ResponseEntity<Optional<Movie>>(movieService.fetchMovie(id), HttpStatus.OK);
    }

    @GetMapping("/imdb/{imdbId}")
        public ResponseEntity<Optional<Movie>>getMovieByImdb(@PathVariable String imdbId){
        return new ResponseEntity<Optional<Movie>>(movieService.fetchMovieByImdb(imdbId), HttpStatus.OK);
    }

    @GetMapping("/title/{title}")
      public ResponseEntity<Optional<Movie>> getMovieByTitle(@PathVariable String title) {
        return new ResponseEntity<Optional<Movie>>(movieService.fetchMovieByTitle(title), HttpStatus.OK);
    }


}