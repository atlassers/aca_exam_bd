package it.euris.cinema.service.impl;

import it.euris.cinema.data.dto.TicketDto;

import java.util.List;

/**
 * @author Busterna Davide
 * @since 2021-10-29
 */
public interface TicketService {

	List<TicketDto> getAll();

	TicketDto get(Long id);

	TicketDto add(TicketDto ticketDto);

	TicketDto update(TicketDto ticketDto);

	Boolean delete(Long id);
}
