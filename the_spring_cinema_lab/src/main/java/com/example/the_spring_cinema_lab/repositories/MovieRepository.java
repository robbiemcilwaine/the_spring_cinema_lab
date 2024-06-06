package com.example.the_spring_cinema_lab.repositories;

import com.example.the_spring_cinema_lab.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// second param of JpaRepository<> should always be the id's data type
// can include @Repository to be more specific
@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
}
