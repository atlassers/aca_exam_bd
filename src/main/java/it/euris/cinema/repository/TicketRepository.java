package it.euris.cinema.repository;

import it.euris.cinema.data.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Busterna Davide
 * @since 2021-10-29
 */
public interface TicketRepository extends JpaRepository<Ticket, Long> {}
