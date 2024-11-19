package com.and_sopt.cdsp.api.movie.repository;

import com.and_sopt.cdsp.api.movie.domain.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}
