package com.and_sopt.cdsp.api.movie.domain;

import com.and_sopt.cdsp.api.theater.domain.Theater;

import com.and_sopt.cdsp.api.ticket.domain.Ticket;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name="movie")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "theater_id", nullable = false)
    @JsonIgnore
    private Theater theater;

    @OneToMany
    private List<Ticket> ticket;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    @Column(name="seat_iOS")
    private String seatiOS;

    @Column(name="seat_And")
    private String seatAnd;

    private boolean isMorning;

    private String movieName;

    private String auditorium;

    private String auditoriumType;

    public Long getId() {
        return id;
    }

    public Theater getTheater() {
        return theater;
    }

    public List<Ticket> getTicket() { return ticket; }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public String getSeatiOS() {
        return seatiOS;
    }

    public String getSeatAnd() {
        return seatAnd;
    }

    public boolean isMorning() {
        return isMorning;
    }

    public String getMovieName() {
        return movieName;
    }

    public String getAuditorium() {
        return auditorium;
    }

    public String getAuditoriumType() {
        return auditoriumType;
    }
}
