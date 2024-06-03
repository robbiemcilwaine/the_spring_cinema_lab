package com.example.the_spring_cinema_lab.repositories;

import com.example.the_spring_cinema_lab.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}
