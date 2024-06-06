package com.example.the_spring_cinema_lab.controllers;


import com.example.the_spring_cinema_lab.models.Movie;
import com.example.the_spring_cinema_lab.models.Reply;
import com.example.the_spring_cinema_lab.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/movies")
public class MovieController {

    @Autowired
    MovieService movieService;

    //    Reply class redundant
//    'value' must match the parameters below it
    @GetMapping(value = "/{id}")
    public ResponseEntity<Movie> findMovie(@PathVariable long id) {
//        access movie by id
        Movie movie = movieService.getMovieById(id).get();
        return new ResponseEntity<>(movie, HttpStatus.OK);
//        generate different replies for if movie is/isn't present
//            can replace reply with movie.get()
    }

    @GetMapping
    public ResponseEntity<List<Movie>> showMovies(@RequestParam(defaultValue = "0") int maxDuration) {
        List<Movie> movies = movieService.getAllMovies();
        List<Movie> moviesLessThanMaxDuration = new ArrayList<>();

        if (maxDuration == 0) {
            return new ResponseEntity<>(movies, HttpStatus.OK);
        }
//      this logic needs to be defined in the service class, and then called below
        for (Movie movie : movies) {
            if (movie.getDuration() < maxDuration) {
                moviesLessThanMaxDuration.add(movie);
            }
        }
        return new ResponseEntity<>(moviesLessThanMaxDuration, HttpStatus.OK);
    }

    //    takes JSON object from postman and adds this to database
    @PostMapping
    public ResponseEntity<Reply> addMovie(@RequestBody Movie movie) {
        movieService.addMovie(movie);
        Reply reply = new Reply("Movie added");
        return new ResponseEntity<>(reply, HttpStatus.CREATED);
    }

    @PatchMapping(value = "/{id}")
    public ResponseEntity<Reply> updateMovie(@PathVariable long id, @RequestBody Movie movie) {
        movieService.updateMovie(id, movie);
        Reply reply = new Reply("Movie updated");
        return new ResponseEntity<>(reply, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Reply> deleteMovie(@PathVariable long id) {
        movieService.removeMovie(id);
        Reply reply = new Reply("Movie removed");
        return new ResponseEntity<>(reply, HttpStatus.GONE);
    }
}
