package com.and_sopt.cdsp.api.movie.service;

import com.and_sopt.cdsp.api.movie.domain.Movie;
import com.and_sopt.cdsp.api.movie.dto.MovieBookingDto;
import com.and_sopt.cdsp.api.movie.dto.MovieDetailDto;
import com.and_sopt.cdsp.api.movie.repository.MovieRepository;
import com.and_sopt.cdsp.api.theater.domain.Theater;
import com.and_sopt.cdsp.api.theater.repository.TheaterRepository;
import com.and_sopt.cdsp.api.ticket.domain.Ticket;
import com.and_sopt.cdsp.api.ticket.repository.TicketRepository;
import com.and_sopt.cdsp.global.exception.CustomException;
import com.and_sopt.cdsp.global.response.ApiResponseDto;
import com.and_sopt.cdsp.global.response.enums.ErrorCode;
import com.and_sopt.cdsp.global.response.enums.SuccessCode;
import java.util.Timer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MovieService {

    private final MovieRepository movieRepository;
    private final TheaterRepository theaterRepository;
    private final TicketRepository ticketRepository;
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm");
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy.MM.dd (E)", Locale.KOREAN);


    public MovieService(MovieRepository movieRepository,
                        TheaterRepository theaterRepository,
                        TicketRepository ticketRepository) {
        this.movieRepository = movieRepository;
        this.theaterRepository = theaterRepository;
        this.ticketRepository = ticketRepository;
    }

    @Transactional(readOnly = true)
    public List<MovieDetailDto>  getMovieDetail(final Long movieId) {

        Movie selectedMovie = movieRepository.findById(movieId)
                .orElseThrow (()->new CustomException(ErrorCode.NOT_FOUND_MOVIE));

        List<Movie> movieList = movieRepository.findMoviesByTheaterId(selectedMovie.getTheater().getId());

        return movieList.stream()
                .sorted(Comparator.comparing(Movie::getStartTime)) //startTime 기준으로 오름차순으로 반환
                .map(movie -> {
                    String releaseDate = movie.getStartTime().toLocalDate().format(DATE_FORMATTER);

                    return MovieDetailDto.builder()
                            .movieId(movie.getId())
                            .movieName(movie.getMovieName())
                            .auditoriumType(movie.getAuditoriumType())
                            .theaterName(movie.getTheater().getTheaterName())
                            .startTime(movie.getStartTime().format(FORMATTER))
                            .endTime(movie.getEndTime().format(FORMATTER))
                            .releaseDate(releaseDate)
                            .isMorning(movie.isMorning())
                            .seatiOS(movie.getSeatiOS())
                            .seatAnd(movie.getSeatAnd())
                            .build();
                })
                .collect(Collectors.toList());
    }

    @Transactional
    public void bookMovie(Long movieId, MovieBookingDto movieBookingDto) {
        Movie movie = movieRepository.findById(movieId).orElseThrow(
                () -> new CustomException(ErrorCode.NOT_FOUND_MOVIE)
        );
        Ticket ticket = Ticket.builder()
                .ticketCount(movieBookingDto.getTicketCount())
                .build();
        ticketRepository.save(ticket);
    }
}
