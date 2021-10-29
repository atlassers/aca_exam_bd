package it.euris.cinema.service.impl;

import it.euris.cinema.data.dto.CinemaDto;
import it.euris.cinema.data.model.Cinema;
import it.euris.cinema.exception.IdMustBeNullException;
import it.euris.cinema.exception.IdMustNotBeNullException;
import it.euris.cinema.repository.CinemaRepository;
import it.euris.cinema.service.CinemaService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Busterna Davide
 * @since 2021-10-29
 */
@Service
public class CinemaServiceImpl implements CinemaService {

  private final CinemaRepository cinemaRepository;

  public CinemaServiceImpl(CinemaRepository cinemaRepository) {
    this.cinemaRepository = cinemaRepository;
  }

  @Override
  public List<CinemaDto> getAll() {
    return cinemaRepository.findAll().stream().map(Cinema::toDto).collect(Collectors.toList());
  }

  @Override
  public CinemaDto get(Long id) {
    return cinemaRepository.findById(id).map(Cinema::toDto).orElse(null);
  }

  @Override
  public CinemaDto add(CinemaDto cinemaDto) {
    if (cinemaDto.getId() != null) throw new IdMustBeNullException();
    return cinemaRepository.save(cinemaDto.toModel()).toDto();
  }

  @Override
  public CinemaDto update(CinemaDto cinemaDto) {
    if (cinemaDto.getId() == null) throw new IdMustNotBeNullException();
    return cinemaRepository.save(cinemaDto.toModel()).toDto();
  }

  @Override
  public Boolean delete(Long id) {
    cinemaRepository.deleteById(id);
    return !cinemaRepository.findById(id).isPresent();
  }
}
