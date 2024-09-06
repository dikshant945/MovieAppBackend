package dev.dikshant.movieApp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "reviews")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Review {
    public Review(String body, String imdbId) {
        this.body = body;
        this.imdbId = imdbId;
    }

    @Id
    private String id;
    private String imdbId;
    private String body;
}
