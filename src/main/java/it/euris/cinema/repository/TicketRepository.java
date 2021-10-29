package it.euris.cinema.repository;

import it.euris.cinema.data.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Busterna Davide
 * @since 2021-10-29
 */
@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {}
