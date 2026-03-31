package com.platzi.play.persistence;

import com.platzi.play.domain.dto.MovieDto;
import com.platzi.play.domain.dto.UpdateMovieDto;
import com.platzi.play.domain.exception.MovieAlreadyExistsException;
import com.platzi.play.domain.repository.MovieRepository;
import com.platzi.play.persistence.crud.CrudMovieEntity;
import com.platzi.play.persistence.entity.MovieEntity;
import com.platzi.play.persistence.mapper.MovieMapper;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class MovieEntityRepository implements MovieRepository {

    private final CrudMovieEntity crudMovieEntity;
    private final MovieMapper mapper;

    public MovieEntityRepository(CrudMovieEntity crudMovieEntity, MovieMapper mapper) {
        this.crudMovieEntity = crudMovieEntity;
        this.mapper = mapper;
    }

    @Override
    public List<MovieDto> getAll() {
        return mapper.toDto(this.crudMovieEntity.findAll());
    }

    @Override
    public MovieDto getById(long id) {
        MovieEntity entity = this.crudMovieEntity.findById(id).orElse(null);
        return this.mapper.toDto(entity);
    }

    @Override
    public MovieDto add(MovieDto movieDto) {
        if (this.crudMovieEntity.findFirstByTitle(movieDto.title()) != null) {
            throw new MovieAlreadyExistsException(movieDto.title());
        }
        MovieEntity entity = mapper.toEntity(movieDto);
        entity.setStatus("D");
        return this.mapper.toDto(this.crudMovieEntity.save(entity));
    }

    @Override
    public MovieDto update(long id, UpdateMovieDto movieDto) {
        MovieEntity entity = this.crudMovieEntity.findById(id).orElse(null);
        if (entity == null) return null;
        this.mapper.updateEntityFromDto(movieDto, entity);
        return this.mapper.toDto(this.crudMovieEntity.save(entity));
    }

    @Override
    public void delete(long id) {
        this.crudMovieEntity.deleteById(id);
    }
}
