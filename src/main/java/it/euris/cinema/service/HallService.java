package it.euris.cinema.service;

import it.euris.cinema.data.dto.FilmDto;
import it.euris.cinema.data.dto.HallDto;
import it.euris.cinema.data.dto.SpectatorDto;
import it.euris.cinema.data.dto.TicketDto;

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

  TicketDto createTicket(FilmDto filmDto, SpectatorDto spectatorDto);
}
