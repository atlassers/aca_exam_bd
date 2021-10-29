package it.euris.cinema.service.impl;

import it.euris.cinema.data.dto.TicketDto;
import it.euris.cinema.data.model.Ticket;
import it.euris.cinema.exception.IdMustBeNullException;
import it.euris.cinema.exception.IdMustNotBeNullException;
import it.euris.cinema.repository.TicketRepository;
import it.euris.cinema.service.TicketService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Busterna Davide
 * @since 2021-10-29
 */
@Service
public class TicketServiceImpl implements TicketService {

	private final TicketRepository ticketRepository;

	public TicketServiceImpl(TicketRepository ticketRepository) {
		this.ticketRepository = ticketRepository;
	}

	@Override
	public List<TicketDto> getAll() {
		return ticketRepository.findAll().stream().map(Ticket::toDto).collect(Collectors.toList());
	}

	@Override
	public TicketDto get(Long id) {
		return ticketRepository.findById(id).map(Ticket::toDto).orElse(null);
	}

	@Override
	public TicketDto add(TicketDto ticketDto) {
		if (ticketDto.getId() != null) throw new IdMustBeNullException();
		return ticketRepository.save(ticketDto.toModel()).toDto();
	}

	@Override
	public TicketDto update(TicketDto ticketDto) {
		if (ticketDto.getId() == null) throw new IdMustNotBeNullException();
		return ticketRepository.save(ticketDto.toModel()).toDto();
	}

	@Override
	public Boolean delete(Long id) {
		ticketRepository.deleteById(id);
		return !ticketRepository.findById(id).isPresent();
	}

	@Override
	public List<TicketDto> getTicketsOfHall(Long hallId){
		return ticketRepository.getTicketsOfHall(hallId).stream().map(Ticket::toDto).collect(Collectors.toList());
	}
}
