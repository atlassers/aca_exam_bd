package it.euris.cinema.service.impl;

import it.euris.cinema.data.dto.FilmDto;
import it.euris.cinema.data.dto.HallDto;
import it.euris.cinema.data.dto.SpectatorDto;
import it.euris.cinema.data.dto.TicketDto;
import it.euris.cinema.data.model.Hall;
import it.euris.cinema.exception.IdMustBeNullException;
import it.euris.cinema.exception.IdMustNotBeNullException;
import it.euris.cinema.repository.HallRepository;
import it.euris.cinema.service.FilmService;
import it.euris.cinema.service.HallService;
import it.euris.cinema.service.SpectatorService;
import it.euris.cinema.service.TicketService;
import it.euris.cinema.utils.UT;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * @author Busterna Davide
 * @since 2021-10-29
 */
@Service
public class HallServiceImpl implements HallService {

  private final HallRepository hallRepository;

  private final SpectatorService spectatorService;
  private final TicketService ticketService;
  private final FilmService filmService;

  public HallServiceImpl(HallRepository hallRepository, SpectatorService spectatorService, TicketService ticketService, FilmService filmService) {
    this.hallRepository = hallRepository;
    this.spectatorService = spectatorService;
    this.ticketService = ticketService;
    this.filmService = filmService;
  }

  @Override
  public List<HallDto> getAll() {
    return hallRepository.findAll().stream().map(Hall::toDto).collect(Collectors.toList());
  }

  @Override
  public HallDto get(Long id) {
    return hallRepository.findById(id).map(Hall::toDto).orElse(null);
  }

  @Override
  public HallDto add(HallDto hallDto) {
    if (hallDto.getId() != null) throw new IdMustBeNullException();
    return hallRepository.save(hallDto.toModel()).toDto();
  }

  @Override
  public HallDto update(HallDto hallDto) {
    if (hallDto.getId() == null) throw new IdMustNotBeNullException();
    return hallRepository.save(hallDto.toModel()).toDto();
  }

  @Override
  public Boolean delete(Long id) {
    hallRepository.deleteById(id);
    return !hallRepository.findById(id).isPresent();
  }

  @Override
  public TicketDto createTicket(Long hallId, Long spectatorId) {
    HallDto hallDto = get(hallId);
    FilmDto filmDto = filmService.get(UT.toLong(hallDto.getFilmId()));
    SpectatorDto spectatorDto = spectatorService.get(spectatorId);

    Double price = UT.toDouble(filmDto.getPrice());

    Double discount = price * spectatorDto.getDiscount() / 100.0;
    Double ticketPrice = price - discount;

    String hallPosition = UUID.randomUUID().toString();

    TicketDto ticketDto = TicketDto.builder()
        .hallPosition(hallPosition)
        .price(UT.toString(ticketPrice))
        .hallId(hallDto.getId())
        .build();

    return ticketService.add(ticketDto);
  }
}
