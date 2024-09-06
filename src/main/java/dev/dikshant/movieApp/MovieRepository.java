package dev.dikshant.movieApp;

import java.util.Optional;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends MongoRepository<Movie, ObjectId> {

    Optional<Movie> findMoviesByImdbId(String imdbId);

    Optional<Movie> findMoviesByTitle(String title);

}
