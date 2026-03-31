package com.platzi.play.web.exception;

import lombok.Builder;

@Builder
public record AttributeError(
    String field,
    String message
    ) {
}
