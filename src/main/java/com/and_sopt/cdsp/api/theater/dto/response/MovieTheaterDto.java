package com.and_sopt.cdsp.api.theater.dto.response;

import lombok.Builder;

@Builder
public record MovieTheaterDto(Long id, String theaterName) { }
