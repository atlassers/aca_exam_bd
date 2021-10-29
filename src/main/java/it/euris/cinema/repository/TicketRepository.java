package it.euris.cinema.repository;

import it.euris.cinema.data.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Busterna Davide
 * @since 2021-10-29
 */
@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {

	@Query(value = "SELECT t FROM Ticket t WHERE t.hall.id = :hallId")
	List<Ticket> getTicketsOfHall(@Param("hallId") Long hallId);
}
