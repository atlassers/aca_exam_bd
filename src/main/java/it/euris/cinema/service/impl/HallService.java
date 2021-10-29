package it.euris.cinema.service.impl;

import it.euris.cinema.data.dto.HallDto;

import java.util.List;

/**
 * @author Busterna Davide
 * @since 2021-10-29
 */
public interface HallService {

  List<HallDto> getAll();

  HallDto get(Long id);

  HallDto add(HallDto hallDto);

  HallDto update(HallDto hallDto);

  Boolean delete(Long id);
}
