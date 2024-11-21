package com.and_sopt.cdsp.api.movie.repository;

import com.and_sopt.cdsp.api.movie.domain.Movie;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    List<Movie> findByTheaterIdAndAuditoriumAndAuditoriumType(Long theaterId, String auditorium, String auditoriumType);
}
