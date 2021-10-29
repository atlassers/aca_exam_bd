package it.euris.cinema.service;

import it.euris.cinema.data.dto.FilmDto;

import java.util.List;

/**
 * @author Busterna Davide
 * @since 2021-10-29
 */
public interface FilmService {

  List<FilmDto> getAll();

  FilmDto get(Long id);

  FilmDto add(FilmDto filmDto);

  FilmDto update(FilmDto filmDto);

  Boolean delete(Long id);
}
