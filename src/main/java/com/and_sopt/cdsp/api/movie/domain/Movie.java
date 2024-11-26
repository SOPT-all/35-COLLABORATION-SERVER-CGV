package com.and_sopt.cdsp.api.movie.domain;

import com.and_sopt.cdsp.api.theater.domain.Theater;
import com.and_sopt.cdsp.api.ticket.domain.Ticket;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name="movie")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "theater_id", nullable = false)
    private Theater theater;

    @ManyToOne
    @JoinColumn(name = "ticket_id",nullable = false)
    private Ticket ticket;

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

    public Ticket getTicket() { return ticket; }

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
