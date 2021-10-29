package it.euris.cinema.service;

import it.euris.cinema.data.dto.CinemaDto;

import java.util.List;

/**
 * @author Busterna Davide
 * @since 2021-10-29
 */
public interface CinemaService {

  List<CinemaDto> getAll();

  CinemaDto get(Long id);

  CinemaDto add(CinemaDto cinemaDto);

  CinemaDto update(CinemaDto cinemaDto);

  Boolean delete(Long id);
}
