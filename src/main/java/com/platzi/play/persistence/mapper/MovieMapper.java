package com.platzi.play.persistence.mapper;

import com.platzi.play.domain.dto.MovieDto;
import com.platzi.play.domain.dto.UpdateMovieDto;
import com.platzi.play.persistence.entity.MovieEntity;
import java.util.List;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", uses = { GenreMapper.class, StatusMapper.class })
public interface MovieMapper {

    @Mapping(target = "title", source = "title")
    @Mapping(target = "duration", source = "duration")
    @Mapping(target = "genre", source = "genre", qualifiedByName = "stringToGenre")
    @Mapping(target = "releaseDate", source = "releaseDate")
    @Mapping(target = "rating", source = "rating")
    @Mapping(target = "status", source = "status", qualifiedByName = "stringToStatus")
    MovieDto toDto(MovieEntity entity);
    List<MovieDto> toDto(Iterable<MovieEntity> entities);

    @InheritInverseConfiguration
    @Mapping(target = "status", source = "status", qualifiedByName = "statusToString")
    @Mapping(target = "genre", source = "genre", qualifiedByName = "genreToString")
    MovieEntity toEntity(MovieDto movieDto);

    @Mapping(target = "title", source = "title")
    @Mapping(target = "releaseDate", source = "releaseDate")
    @Mapping(target = "rating", source = "rating")
    void updateEntityFromDto(UpdateMovieDto dto, @MappingTarget MovieEntity entity);
}
