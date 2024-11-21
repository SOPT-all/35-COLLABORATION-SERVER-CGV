package com.and_sopt.cdsp.api.theater.service;

import com.and_sopt.cdsp.api.theater.domain.Theater;
import com.and_sopt.cdsp.api.theater.repository.TheaterRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TheaterService {

    private final TheaterRepository theaterRepository;
    public TheaterService(TheaterRepository theaterRepository) {
        this.theaterRepository = theaterRepository;
    }

    public List<Theater> getAllTheaters() {
        return theaterRepository.findAll();
    }
}
