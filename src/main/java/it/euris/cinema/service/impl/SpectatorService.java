package it.euris.cinema.service.impl;

import it.euris.cinema.data.dto.SpectatorDto;

import java.util.List;

/**
 * @author Busterna Davide
 * @since 2021-10-29
 */
public interface SpectatorService {

  List<SpectatorDto> getAll();

  SpectatorDto get(Long id);

  SpectatorDto add(SpectatorDto spectatorDto);

  SpectatorDto update(SpectatorDto spectatorDto);

  Boolean delete(Long id);
}
