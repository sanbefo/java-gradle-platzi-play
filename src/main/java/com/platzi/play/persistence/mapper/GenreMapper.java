package com.platzi.play.persistence.mapper;

import static com.platzi.play.domain.Genre.ACTION;
import static com.platzi.play.domain.Genre.ANIMATED;
import static com.platzi.play.domain.Genre.COMEDY;
import static com.platzi.play.domain.Genre.DRAMA;
import static com.platzi.play.domain.Genre.HORROR;
import static com.platzi.play.domain.Genre.SCI_FI;

import com.platzi.play.domain.Genre;
import org.mapstruct.Named;

public class GenreMapper {

    @Named("stringToGenre")
    public static Genre StringToGenre(String genre) {
        if (genre == null) return null;
        return switch (genre.toUpperCase()) {
            case "ACTION" -> ACTION;
            case "COMEDY" -> COMEDY;
            case "DRAMA" -> DRAMA;
            case "ANIMATED" -> ANIMATED;
            case "HORROR" -> HORROR;
            case "SCI_FI" -> SCI_FI;
            default -> null;
        };
    }

    @Named("genreToString")
    public static String genreToString(Genre genre) {
        if (genre == null) return null;
        return switch (genre) {
            case ACTION ->  "ACTION";
            case COMEDY ->  "COMEDY";
            case DRAMA ->  "DRAMA";
            case ANIMATED ->  "ANIMATED";
            case HORROR ->  "HORROR";
            case SCI_FI ->  "SCI_FI";
            default -> null;
        };
    }
}
