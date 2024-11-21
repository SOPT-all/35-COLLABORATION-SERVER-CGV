package com.and_sopt.cdsp.api.movie.controller;

import com.and_sopt.cdsp.api.movie.dto.MovieDetailDto;
import com.and_sopt.cdsp.api.movie.service.MovieService;
import com.and_sopt.cdsp.global.response.ApiResponseDto;
import com.and_sopt.cdsp.global.response.enums.SuccessCode;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movie")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/{movieId}")
    public ApiResponseDto<MovieDetailDto> getMovieDetail( @PathVariable final long movieId){
        return ApiResponseDto.success(SuccessCode.MOVIE_DETAIL_GET_SUCCESS,movieService.getMovieDetail(movieId));
    }
}
