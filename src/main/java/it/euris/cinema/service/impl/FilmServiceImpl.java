package it.euris.cinema.service.impl;

import it.euris.cinema.data.dto.FilmDto;
import it.euris.cinema.data.model.Film;
import it.euris.cinema.exception.IdMustBeNullException;
import it.euris.cinema.exception.IdMustNotBeNullException;
import it.euris.cinema.repository.FilmRepository;
import it.euris.cinema.service.FilmService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Busterna Davide
 * @since 2021-10-29
 */
@Service
public class FilmServiceImpl implements FilmService {

	private final FilmRepository filmRepository;

	public FilmServiceImpl(FilmRepository filmRepository) {
		this.filmRepository = filmRepository;
	}

	@Override
	public List<FilmDto> getAll() {
		return filmRepository.findAll().stream().map(Film::toDto).collect(Collectors.toList());
	}

	@Override
	public FilmDto get(Long id) {
		return filmRepository.findById(id).map(Film::toDto).orElse(null);
	}

	@Override
	public FilmDto add(FilmDto filmDto) {
		if (filmDto.getId() != null) throw new IdMustBeNullException();
		return filmRepository.save(filmDto.toModel()).toDto();
	}

	@Override
	public FilmDto update(FilmDto filmDto) {
		if (filmDto.getId() == null) throw new IdMustNotBeNullException();
		return filmRepository.save(filmDto.toModel()).toDto();
	}

	@Override
	public Boolean delete(Long id) {
		filmRepository.deleteById(id);
		return !filmRepository.findById(id).isPresent();
	}
}
