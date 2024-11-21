package com.and_sopt.cdsp.api.theater.domain;

import jakarta.persistence.*;


@Entity
@Table(name="theater")
public class Theater {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String theaterName;

    public Long getId() {
        return id;
    }

    public String getTheaterName() {
        return theaterName;
    }
}
