package com.laboratorykkoon9.springjpa.movie.repository;

import com.laboratorykkoon9.springjpa.movie.domain.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
    List<Movie> findByDirectorName(String directorName);
}
