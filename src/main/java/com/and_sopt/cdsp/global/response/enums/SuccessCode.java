package com.and_sopt.cdsp.global.response.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum SuccessCode {

    //200 OK
    MOVIE_TIMELINE_GET_SUCCESS(20001, HttpStatus.OK, "영화 시간표 조회 성공"),
    MOVIE_DETAIL_GET_SUCCESS(20002, HttpStatus.OK, "영화 세부 정보 조회 성공"),
    MOVIE_THEATER_GET_SUCCESS(20003, HttpStatus.OK, "영화관 조회 성공"),

    //201 CREATED
    MOVIE_BOOKING_POST_SUCCESS(20101, HttpStatus.CREATED, "영화 예매 성공");

    private final int code;
    private final HttpStatus httpStatus;
    private final String message;
}
