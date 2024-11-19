package com.and_sopt.cdsp.api.theater.domain;

import com.and_sopt.cdsp.api.movie.domain.Movie;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.List;

@Entity
public class Theater {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany
    private List<Movie> movieList;

    private String theaterName;

    private String auditorium;

    private String auditoriumType;

}
