package com.platzi.play.persistence.mapper;

import static com.platzi.play.domain.Status.AVAILABLE;
import static com.platzi.play.domain.Status.NOT_AVAILABLE;

import com.platzi.play.domain.Status;
import org.mapstruct.Named;

public class StatusMapper {

    @Named("stringToStatus")
    public static Status StringToStatus(String status) {
        if (status == null) return null;
        return switch (status.toUpperCase()) {
            case "D" -> AVAILABLE;
            case "N" -> NOT_AVAILABLE;
            default -> null;
        };
    }

    @Named("statusToString")
    public static String StatusToString(Status status) {
        if (status == null) return null;
        return switch (status) {
            case AVAILABLE -> "D";
            case NOT_AVAILABLE -> "N";
            default -> null;
        };
    }
}
