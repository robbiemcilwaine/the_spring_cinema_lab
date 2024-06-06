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
// this is a java application representing relationships between data
@Service
public class MovieService {

//    with @Autowired, this object is going to be available for us to use in this class
//    now have access to all the object's methods
    @Autowired
    MovieRepository movieRepository;

    public MovieService(){

    }

//    'optional' acts as a wrapper around whatever this method gives us
//    without it, would need to call .get() on the movieRepository.findById(id);
    public Optional<Movie> getMovieById(long id){
        return movieRepository.findById(id);
//        return movieRepository.findById(id).get();
    }

    public List<Movie> getAllMovies(){
        return this.movieRepository.findAll();
    }

    public Movie addMovie(Movie movie){
//        this returns a copy
        return movieRepository.save(movie);
//        movieRepository.save(movie);
//        return movie;
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
