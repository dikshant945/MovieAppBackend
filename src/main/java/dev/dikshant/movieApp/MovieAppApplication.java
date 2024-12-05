package dev.dikshant.movieApp;

import io.github.cdimascio.dotenv.Dotenv;
import java.security.PublicKey;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class MovieAppApplication {
	public static void main(String[] args) {
		SpringApplication.run(MovieAppApplication.class, args);
	}
}
