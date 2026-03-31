package com.platzi.play.web.exception;

import com.platzi.play.domain.exception.MovieAlreadyExistsException;
import jakarta.servlet.http.HttpServletRequest;
import java.util.UUID;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestExceptionHandler  {

    @ExceptionHandler(MovieAlreadyExistsException.class)
    public ResponseEntity<Error> handleException(MovieAlreadyExistsException ex,
        HttpServletRequest request) {
        String requestId = request.getHeader("X-Request-Id");
        if (requestId == null || requestId.isEmpty()) {
            requestId = UUID.randomUUID().toString();
        }
        Error error = Error.builder()
            .requestId(requestId)
            .type("movie-already-exists")
            .message(ex.getMessage())
            .status(HttpStatus.BAD_REQUEST.value())
            .path(request.getRequestURL().toString())
            .method(request.getMethod())
            .timestamp(java.time.LocalDateTime.now())
            .build();
        return ResponseEntity.badRequest().body(error);
    }
}
