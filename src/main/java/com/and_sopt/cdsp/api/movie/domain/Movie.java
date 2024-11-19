package com.and_sopt.cdsp.api.movie.domain;

import com.and_sopt.cdsp.api.theater.domain.Theater;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.time.LocalDateTime;

@Entity

public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Theater theater;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    private String imageUrl;

    private boolean isMorning;

    private String movieName;

}
