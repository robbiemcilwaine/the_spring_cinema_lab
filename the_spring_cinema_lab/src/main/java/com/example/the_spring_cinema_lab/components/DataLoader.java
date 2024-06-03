package com.example.the_spring_cinema_lab.components;

import com.example.the_spring_cinema_lab.models.Movie;
import com.example.the_spring_cinema_lab.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    MovieService movieService;

    @Override
    public void run(ApplicationArguments args) throws Exception{
        movieService.addMovie(new Movie("Scarface", "18", 134));
    }
}
