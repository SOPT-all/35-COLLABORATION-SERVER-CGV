package com.and_sopt.cdsp.api.theater.service;

import com.and_sopt.cdsp.api.movie.domain.Movie;
import com.and_sopt.cdsp.api.movie.repository.MovieRepository;
import com.and_sopt.cdsp.api.theater.dto.response.MovieTheaterDto;
import com.and_sopt.cdsp.api.theater.dto.response.MovieTimelineGetResponse;
import com.and_sopt.cdsp.api.theater.domain.Theater;
import com.and_sopt.cdsp.api.theater.repository.TheaterRepository;
import com.and_sopt.cdsp.global.exception.CustomException;
import com.and_sopt.cdsp.global.response.enums.ErrorCode;
import java.util.List;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TheaterService {

    private final TheaterRepository theaterRepository;
    private final MovieRepository movieRepository;

    public TheaterService(TheaterRepository theaterRepository, MovieRepository movieRepository) {
        this.theaterRepository = theaterRepository;
        this.movieRepository = movieRepository;
    }

    public MovieTimelineGetResponse getMovieTimeline(Long theaterId, String auditorium, String auditoriumType) {
        Theater theater = theaterRepository.findById(theaterId)
                .orElseThrow(
                        () -> new CustomException(ErrorCode.THEATER_NOT_FOUND));
        List<Movie> movieList = movieRepository.findByTheaterIdAndAuditoriumAndAuditoriumType(theaterId, auditorium,
                auditoriumType);
        return MovieTimelineGetResponse.builder()
                .movieList(movieList)
                .build();
    }

    public List<MovieTheaterDto> getAllTheaters() {
        return theaterRepository.findAll()
                .stream()
                .map(theater -> MovieTheaterDto.builder()
                        .id(theater.getId())
                        .theaterName(theater.getTheaterName())
                        .build())
                .toList();
    }
}
