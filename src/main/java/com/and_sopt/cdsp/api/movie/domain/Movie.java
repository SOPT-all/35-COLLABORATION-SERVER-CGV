package com.and_sopt.cdsp.api.movie.domain;

import com.and_sopt.cdsp.api.theater.domain.Theater;
import com.and_sopt.cdsp.global.common.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;

@Entity
@Getter
public class Movie extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "theater_id", nullable = false)
    private Theater theater;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    private String imageUrl;

    private boolean isMorning;

    private String movieName;

}
