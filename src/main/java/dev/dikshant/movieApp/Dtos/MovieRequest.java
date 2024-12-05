package dev.dikshant.movieApp.Dtos;
import lombok.Data;
import org.springframework.lang.NonNull;
import org.springframework.lang.NonNullFields;

import java.util.List;

@Data
public class MovieRequest {
    private String imdbId;
    private String title;
    private String releaseDate;
    private String trailerLink;
    private String poster;
    private List<String> genres;
    private List<String> backdrops;
}
