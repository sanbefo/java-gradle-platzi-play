package com.platzi.play.web.exception;

import com.platzi.play.domain.exception.MovieAlreadyExistsException;
import jakarta.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
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

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Error> handleException(MethodArgumentNotValidException ex,
        HttpServletRequest request) {
        String requestId = request.getHeader("X-Request-Id");
        if (requestId == null || requestId.isEmpty()) {
            requestId = UUID.randomUUID().toString();
        }        Error error = Error.builder()
            .requestId(requestId)
            .type("updating-fields-error")
            .message(ex.getMessage())
            .status(HttpStatus.BAD_REQUEST.value())
            .path(request.getRequestURL().toString())
            .method(request.getMethod())
            .timestamp(java.time.LocalDateTime.now())
            .attributeErrors(new ArrayList<>())
            .build();
        List<AttributeError> errors = new ArrayList<>();
        ex.getFieldErrors().forEach(attrError ->
            error.attributeErrors().add(new AttributeError(attrError.getField(), attrError.getDefaultMessage())));
        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Error> handleException(Exception ex,
        HttpServletRequest request) {
        String requestId = request.getHeader("X-Request-Id");
        if (requestId == null || requestId.isEmpty()) {
            requestId = UUID.randomUUID().toString();
        }
        Error error = Error.builder()
            .requestId(requestId)
            .type("internal-server-error")
            .message(ex.getMessage())
            .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
            .path(request.getRequestURL().toString())
            .method(request.getMethod())
            .timestamp(java.time.LocalDateTime.now())
            .build();
        return ResponseEntity.internalServerError().body(error);
    }
}
