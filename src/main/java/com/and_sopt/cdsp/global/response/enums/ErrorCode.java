package com.and_sopt.cdsp.global.response.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    //404 Not Found
    NOT_FOUND(40000, HttpStatus.NOT_FOUND, "존재하지 않는 API입니다."),

    //500 Internal Server Error
    INTERNAL_SERVER_ERROR(50000, HttpStatus.INTERNAL_SERVER_ERROR, "서버 내부 오류입니다.");

    private final int code;
    private final HttpStatus httpStatus;
    private final String message;
}
