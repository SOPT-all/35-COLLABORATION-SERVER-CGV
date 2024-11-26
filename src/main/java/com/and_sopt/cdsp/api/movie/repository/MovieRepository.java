package com.and_sopt.cdsp.api.movie.repository;

import com.and_sopt.cdsp.api.movie.domain.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface MovieRepository extends JpaRepository<Movie, Long> {

    List<Movie> findMoviesByTheaterId(Long theaterId);
    Optional<Movie> findMovieByMovieNameAndTheater_TheaterName(String movieName, String theaterName);
}
