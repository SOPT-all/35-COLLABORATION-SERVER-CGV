package com.and_sopt.cdsp.api.movie.service;

import com.and_sopt.cdsp.api.movie.domain.Movie;
import com.and_sopt.cdsp.api.movie.dto.MovieDetailDto;
import com.and_sopt.cdsp.api.movie.repository.MovieRepository;
import com.and_sopt.cdsp.global.exception.CustomException;
import com.and_sopt.cdsp.global.response.enums.ErrorCode;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;

@Service
public class MovieService {

    private final MovieRepository movieRepository;
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy:MM:dd HH:mm");


    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }
    public MovieDetailDto getMovieDetail(final long movieId) {
        Movie movie = movieRepository.findById(movieId)
                .orElseThrow (()->new CustomException(ErrorCode.NOT_FOUND));
        return MovieDetailDto.builder()
                .movieId(movie.getId())
                .movieName(movie.getMovieName())
                .auditorium(movie.getTheater().getAuditorium())
                .theaterName(movie.getTheater().getTheaterName())
                .imageUrl(movie.getImageUrl())
                .isMorning(movie.isMorning())
                .startTime(movie.getStartTime().format(FORMATTER))
                .endTime(movie.getEndTime().format(FORMATTER))
                .build();
    }
}
