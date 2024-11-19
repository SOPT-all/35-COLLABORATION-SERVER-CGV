package com.and_sopt.cdsp.global.response.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum SuccessCode {

    //200 OK
    MOVIE_TIMELINE_GET_SUCCESS(20001, HttpStatus.OK, "영화 시간표 조회 성공");

    private final int code;
    private final HttpStatus httpStatus;
    private final String message;
}
