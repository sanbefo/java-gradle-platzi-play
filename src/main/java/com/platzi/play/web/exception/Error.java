package com.platzi.play.web.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Builder;

@Builder
public record Error(
    String requestId,
    String type,
    String message,
    int status,
    String path,
    String method,
    LocalDateTime timestamp,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    List<AttributeError> attributeErrors) {
}
