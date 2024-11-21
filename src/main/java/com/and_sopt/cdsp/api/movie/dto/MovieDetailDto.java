package com.and_sopt.cdsp.api.movie.dto;

import lombok.Builder;

@Builder
public record MovieDetailDto( Long movieId, String movieName,String auditoriumType,String theaterName,
                              String startTime,
                              String endTime,
                              String releaseDate,
                              Boolean isMorning, String seatiOS, String seatAnd
                            ) { }
