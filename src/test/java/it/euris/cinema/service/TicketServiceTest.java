package it.euris.cinema.service;

import it.euris.cinema.data.dto.TicketDto;
import it.euris.cinema.data.model.Ticket;
import it.euris.cinema.repository.TicketRepository;
import it.euris.cinema.service.TicketService;
import it.euris.cinema.service.impl.TicketServiceImpl;
import it.euris.cinema.utils.TestSupport;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

/**
 * @author Busterna Davide
 * @since 2021-10-29
 */
@ExtendWith(MockitoExtension.class)
public class TicketServiceTest {

  private TicketService ticketService;

  @Mock TicketRepository ticketRepository;

  @BeforeEach
  void initialize() {
    ticketService = new TicketServiceImpl(ticketRepository);
  }

  @Test
  @DisplayName("Given a list of tickets to get When getAll Then return those tickets")
  void getAll() {
    List<Ticket> mockedTickets = TestSupport.createTicketList();
    when(ticketRepository.findAll()).thenReturn(mockedTickets);

    List<TicketDto> result = ticketService.getAll();

    assertEquals(mockedTickets.size(), result.size());
    for (int i = 0; i < mockedTickets.size(); i++)
      assertEquals(mockedTickets.get(i).toDto(), result.get(i));
  }

  @Test
  @DisplayName("Given a ticket to get When get Then return this ticket")
  void get() {
    final Long ID = 1L;
    Ticket mockedTicket = TestSupport.createTicket(ID);
    when(ticketRepository.findById(ID)).thenReturn(Optional.of(mockedTicket));

    TicketDto result = ticketService.get(ID);

    assertEquals(mockedTicket.toDto(), result);
  }

  @Test
  @DisplayName("Given a ticket to add When add Then add a ticket")
  void add() {
    Ticket ticketToAdd = TestSupport.createTicket(null);
    Ticket ticketToReturn = TestSupport.createTicket(1L);
    when(ticketRepository.save(any())).thenReturn(ticketToReturn);

    TicketDto result = ticketService.add(ticketToAdd.toDto());

    assertEquals(ticketToReturn.toDto(), result);
  }

  @Test
  @DisplayName("Given a ticket to update When update Then update the ticket")
  void update() {
    Ticket ticketToUpdate = TestSupport.createTicket(1L);
    Ticket ticketToReturn = TestSupport.createTicket(2L);
    when(ticketRepository.save(any())).thenReturn(ticketToReturn);

    TicketDto result = ticketService.update(ticketToUpdate.toDto());

    assertEquals(ticketToReturn.toDto(), result);
  }

  @Test
  @DisplayName("Given a ticket to delete When delete Then delete the ticket")
  void delete() {
    final Long ID = 1L;
    doNothing().when(ticketRepository).deleteById(ID);
    when(ticketRepository.findById(ID)).thenReturn(Optional.empty());

    Boolean result = ticketService.delete(ID);

    assertTrue(result);
  }
}
