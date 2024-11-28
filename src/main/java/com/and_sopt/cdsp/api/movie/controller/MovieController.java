package com.and_sopt.cdsp.api.movie.controller;

import com.and_sopt.cdsp.api.movie.dto.MovieBookingDto;
import com.and_sopt.cdsp.api.movie.dto.MovieDetailDto;
import com.and_sopt.cdsp.api.movie.service.MovieService;
import com.and_sopt.cdsp.global.response.ApiResponseDto;
import com.and_sopt.cdsp.global.response.enums.SuccessCode;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movie")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/{movieId}")
    public ApiResponseDto<List<MovieDetailDto>> getMovieDetail(@PathVariable final Long movieId){
        return ApiResponseDto.success(SuccessCode.MOVIE_DETAIL_GET_SUCCESS,movieService.getMovieDetail(movieId));
    }

    @PostMapping("/booking/{movieId}")
    public ApiResponseDto<MovieBookingDto> postMovieBooking(
            @PathVariable("movieId") final Long movieId,
            @Valid @RequestBody final MovieBookingDto movieBookingDto){
        movieService.bookMovie(movieId, movieBookingDto);
        return ApiResponseDto.success(SuccessCode.MOVIE_BOOKING_POST_SUCCESS);
    }
}
