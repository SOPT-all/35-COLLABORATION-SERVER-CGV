package com.and_sopt.cdsp.api.movie.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MovieBookingDto {
    private String movieName;
    private String theaterName;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private int ticketCount;
}

