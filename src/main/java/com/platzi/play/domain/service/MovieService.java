package com.platzi.play.domain.service;

import com.platzi.play.domain.dto.MovieDto;
import com.platzi.play.domain.dto.UpdateMovieDto;
import com.platzi.play.domain.repository.MovieRepository;
import dev.langchain4j.agent.tool.Tool;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Tool("look for all movies on the platform")
    public List<MovieDto> getAll() {
        return this.movieRepository.getAll();
    }

    public MovieDto getById(long id) {
        return this.movieRepository.getById(id);
    }

    public MovieDto add(MovieDto dto) {
        return this.movieRepository.add(dto);
    }

    public MovieDto update(long id, UpdateMovieDto dto) {
        return this.movieRepository.update(id, dto);
    }

    public void delete(long id) {
        if (this.movieRepository.getById(id) == null) {
            throw new RuntimeException("Movie not found with id " + id);
        }
        this.movieRepository.delete(id);
    }
}
