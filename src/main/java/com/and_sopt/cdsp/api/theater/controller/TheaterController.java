package com.and_sopt.cdsp.api.theater.controller;

import com.and_sopt.cdsp.api.theater.dto.response.MovieTimelineGetResponse;
import com.and_sopt.cdsp.api.theater.service.TheaterService;
import com.and_sopt.cdsp.global.response.ApiResponseDto;
import com.and_sopt.cdsp.global.response.enums.SuccessCode;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TheaterController {

    private final TheaterService theaterService;

    public TheaterController(TheaterService theaterService) {
        this.theaterService = theaterService;
    }

    @GetMapping("/theater/{theaterId}/movie")
    public ApiResponseDto<MovieTimelineGetResponse> getMovieTimeline(@PathVariable("theaterId") final Long theaterId,
                                                                     @RequestParam("auditorium") final String auditorium,
                                                                     @RequestParam("auditoriumType") final String auditoriumType) {
        return ApiResponseDto.success(SuccessCode.MOVIE_TIMELINE_GET_SUCCESS, theaterService.getMovieTimeline(theaterId, auditorium, auditoriumType));
    }

}
