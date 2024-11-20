package com.and_sopt.cdsp.global.exception;

import com.and_sopt.cdsp.global.response.enums.ErrorCode;

public class BadRequestException extends CustomException {
    public BadRequestException(ErrorCode errorCode) {
        super(errorCode);
    }
}
