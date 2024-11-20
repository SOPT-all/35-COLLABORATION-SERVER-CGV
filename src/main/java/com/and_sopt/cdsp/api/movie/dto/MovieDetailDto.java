package com.and_sopt.cdsp.api.movie.dto;

import lombok.Builder;

@Builder
public record MovieDetailDto( long movieId, String movieName,String theaterName,
                              String auditorium,
                              Boolean isMorning, String imageUrl,
                              String startTime,
                              String endTime) {

}
