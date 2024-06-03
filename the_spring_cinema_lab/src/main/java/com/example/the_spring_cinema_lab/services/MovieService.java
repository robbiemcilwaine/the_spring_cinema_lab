package com.example.the_spring_cinema_lab.services;

import com.example.the_spring_cinema_lab.models.Movie;
import com.example.the_spring_cinema_lab.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

// getMovieById
// addMovie
// removeMovie
@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    public MovieService(){

    }

    public Optional<Movie> getMovieById(long id){
        return movieRepository.findById(id);
    }

    public List<Movie> getAllMovies(){
        return this.movieRepository.findAll();
    }

    public Movie addMovie(Movie movie){
        return movieRepository.save(movie);
    }

    public void updateMovie(long id, Movie newMovie){
//        access movie by id, then pass in new movie object to change attributes
        Optional<Movie> movieToChange = getMovieById(id);
        Movie actualMovie = movieToChange.get();

//        use setters and getters to change movie
        actualMovie.setDuration(newMovie.getDuration());
        actualMovie.setRating(newMovie.getRating());
        actualMovie.setTitle(newMovie.getTitle());

        movieRepository.save(actualMovie);
    }

    public void removeMovie(long id){
        Optional<Movie> movie = getMovieById(id);
        Movie movieToChange = movie.get();
        movieRepository.delete(movieToChange);
    }

}
