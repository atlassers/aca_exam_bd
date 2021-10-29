package it.euris.cinema.service;

import it.euris.cinema.data.dto.HallDto;
import it.euris.cinema.data.model.Hall;
import it.euris.cinema.repository.HallRepository;
import it.euris.cinema.service.impl.HallServiceImpl;
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
public class HallServiceTest {

  private HallService hallService;

  @Mock HallRepository hallRepository;
  @Mock SpectatorService spectatorService;
  @Mock TicketService ticketService;
  @Mock FilmService filmService;

  @BeforeEach
  void initialize() {
    hallService = new HallServiceImpl(hallRepository, spectatorService, ticketService, filmService);
  }

  @Test
  @DisplayName("Given a list of halls to get When getAll Then return those halls")
  void getAll() {
    List<Hall> mockedHalls = TestSupport.createHallList();
    when(hallRepository.findAll()).thenReturn(mockedHalls);

    List<HallDto> result = hallService.getAll();

    assertEquals(mockedHalls.size(), result.size());
    for (int i = 0; i < mockedHalls.size(); i++)
      assertEquals(mockedHalls.get(i).toDto(), result.get(i));
  }

  @Test
  @DisplayName("Given a hall to get When get Then return this hall")
  void get() {
    final Long ID = 1L;
    Hall mockedHall = TestSupport.createHall(ID);
    when(hallRepository.findById(ID)).thenReturn(Optional.of(mockedHall));

    HallDto result = hallService.get(ID);

    assertEquals(mockedHall.toDto(), result);
  }

  @Test
  @DisplayName("Given a hall to add When add Then add a hall")
  void add() {
    Hall hallToAdd = TestSupport.createHall(null);
    Hall hallToReturn = TestSupport.createHall(1L);
    when(hallRepository.save(any())).thenReturn(hallToReturn);

    HallDto result = hallService.add(hallToAdd.toDto());

    assertEquals(hallToReturn.toDto(), result);
  }

  @Test
  @DisplayName("Given a hall to update When update Then update the hall")
  void update() {
    Hall hallToUpdate = TestSupport.createHall(1L);
    Hall hallToReturn = TestSupport.createHall(2L);
    when(hallRepository.save(any())).thenReturn(hallToReturn);

    HallDto result = hallService.update(hallToUpdate.toDto());

    assertEquals(hallToReturn.toDto(), result);
  }

  @Test
  @DisplayName("Given a hall to delete When delete Then delete the hall")
  void delete() {
    final Long ID = 1L;
    doNothing().when(hallRepository).deleteById(ID);
    when(hallRepository.findById(ID)).thenReturn(Optional.empty());

    Boolean result = hallService.delete(ID);

    assertTrue(result);
  }
}
