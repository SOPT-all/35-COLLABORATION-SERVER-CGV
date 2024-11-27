package com.and_sopt.cdsp.api.theater.dto.response;

import com.and_sopt.cdsp.api.movie.domain.Movie;
import java.util.List;
import lombok.Builder;

@Builder
public record MovieTimelineGetResponse(
        List<Movie> movieList
) {
}
