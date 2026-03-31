package com.platzi.play.web.exception;

import java.time.LocalDateTime;
import lombok.Builder;

@Builder
public record Error(
    String requestId,
    String type,
    String message,
    int status,
    String path,
    String method,
    LocalDateTime timestamp) {
}
