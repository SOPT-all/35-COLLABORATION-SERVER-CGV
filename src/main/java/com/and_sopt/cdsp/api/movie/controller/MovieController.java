package com.and_sopt.cdsp.api.movie.controller;

import com.and_sopt.cdsp.api.movie.service.MovieService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

}
