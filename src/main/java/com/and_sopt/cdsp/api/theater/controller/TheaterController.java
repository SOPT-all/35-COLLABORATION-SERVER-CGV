package com.and_sopt.cdsp.api.theater.controller;

import com.and_sopt.cdsp.api.theater.service.TheaterService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TheaterController {

    private final TheaterService theaterService;

    public TheaterController(TheaterService theaterService) {
        this.theaterService = theaterService;
    }
}
