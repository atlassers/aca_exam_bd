package it.euris.cinema.service.impl;

import it.euris.cinema.data.dto.SpectatorDto;
import it.euris.cinema.data.model.Spectator;
import it.euris.cinema.exception.IdMustBeNullException;
import it.euris.cinema.exception.IdMustNotBeNullException;
import it.euris.cinema.repository.SpectatorRepository;
import it.euris.cinema.service.SpectatorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Busterna Davide
 * @since 2021-10-29
 */
@Service
public class SpectatorServiceImpl implements SpectatorService {

	private final SpectatorRepository spectatorRepository;

	public SpectatorServiceImpl(SpectatorRepository spectatorRepository) {
		this.spectatorRepository = spectatorRepository;
	}

	@Override
	public List<SpectatorDto> getAll() {
		return spectatorRepository.findAll().stream().map(Spectator::toDto).collect(Collectors.toList());
	}

	@Override
	public SpectatorDto get(Long id) {
		return spectatorRepository.findById(id).map(Spectator::toDto).orElse(null);
	}

	@Override
	public SpectatorDto add(SpectatorDto spectatorDto) {
		if (spectatorDto.getId() != null) throw new IdMustBeNullException();
		return spectatorRepository.save(spectatorDto.toModel()).toDto();
	}

	@Override
	public SpectatorDto update(SpectatorDto spectatorDto) {
		if (spectatorDto.getId() == null) throw new IdMustNotBeNullException();
		return spectatorRepository.save(spectatorDto.toModel()).toDto();
	}

	@Override
	public Boolean delete(Long id) {
		spectatorRepository.deleteById(id);
		return !spectatorRepository.findById(id).isPresent();
	}
}
