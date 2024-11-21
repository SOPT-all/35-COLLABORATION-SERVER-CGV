package com.and_sopt.cdsp.api.theater.controller;

import com.and_sopt.cdsp.api.theater.domain.Theater;
import com.and_sopt.cdsp.api.theater.service.TheaterService;
import com.and_sopt.cdsp.global.response.ApiResponseDto;
import com.and_sopt.cdsp.global.response.enums.SuccessCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/theater")
public class TheaterController {
    private final TheaterService theaterService;

    public TheaterController(TheaterService theaterService) {
        this.theaterService = theaterService;
    }

    @GetMapping
    public ApiResponseDto<List<Theater>> getTheaters() {
        return ApiResponseDto.success(SuccessCode.MOVIE_THEATER_GET_SUCCESS, theaterService.getAllTheaters());
    }
}
