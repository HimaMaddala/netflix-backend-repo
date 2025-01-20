package com.hotstar.backend.controller;

import com.hotstar.backend.model.Movie;
import com.hotstar.backend.repository.MovieRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class MovieController {
    @GetMapping("/health")
    public String healtCheck (){
        return "Test Successfull";
    }

    private final MovieRepository movieRepository;

    public MovieController(MovieRepository movieRepository) {
       this.movieRepository = movieRepository;
    }

    @GetMapping("/movies")
    public List<Movie> getAllMovies() {
       return movieRepository.findAll();
    }

    Add a movie
    @PostMapping("/movies")
    public Movie addMovie(@RequestBody Movie movie) {
        return movieRepository.save(movie);
   }
}
