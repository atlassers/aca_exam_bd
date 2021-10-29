package it.euris.cinema.service;

import it.euris.cinema.data.dto.CinemaDto;
import it.euris.cinema.data.model.Cinema;
import it.euris.cinema.repository.CinemaRepository;
import it.euris.cinema.service.impl.CinemaServiceImpl;
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
public class CinemaServiceTest {

  private CinemaService cinemaService;

  @Mock CinemaRepository cinemaRepository;

  @BeforeEach
  void initialize() {
    cinemaService = new CinemaServiceImpl(cinemaRepository);
  }

  @Test
  @DisplayName("Given a list of cinemas to get When getAll Then return those cinemas")
  void getAll() {
    List<Cinema> mockedCinemas = TestSupport.createCinemaList();
    when(cinemaRepository.findAll()).thenReturn(mockedCinemas);

    List<CinemaDto> result = cinemaService.getAll();

    assertEquals(mockedCinemas.size(), result.size());
    for (int i = 0; i < mockedCinemas.size(); i++)
      assertEquals(mockedCinemas.get(i).toDto(), result.get(i));
  }

  @Test
  @DisplayName("Given a cinema to get When get Then return this cinema")
  void get() {
    final Long ID = 1L;
    Cinema mockedCinema = TestSupport.createCinema(ID);
    when(cinemaRepository.findById(ID)).thenReturn(Optional.of(mockedCinema));

    CinemaDto result = cinemaService.get(ID);

    assertEquals(mockedCinema.toDto(), result);
  }

  @Test
  @DisplayName("Given a cinema to add When add Then add a cinema")
  void add() {
    Cinema cinemaToAdd = TestSupport.createCinema(null);
    Cinema cinemaToReturn = TestSupport.createCinema(1L);
    when(cinemaRepository.save(any())).thenReturn(cinemaToReturn);

    CinemaDto result = cinemaService.add(cinemaToAdd.toDto());

    assertEquals(cinemaToReturn.toDto(), result);
  }

  @Test
  @DisplayName("Given a cinema to update When update Then update the cinema")
  void update() {
    Cinema cinemaToUpdate = TestSupport.createCinema(1L);
    Cinema cinemaToReturn = TestSupport.createCinema(2L);
    when(cinemaRepository.save(any())).thenReturn(cinemaToReturn);

    CinemaDto result = cinemaService.update(cinemaToUpdate.toDto());

    assertEquals(cinemaToReturn.toDto(), result);
  }

  @Test
  @DisplayName("Given a cinema to delete When delete Then delete the cinema")
  void delete() {
    final Long ID = 1L;
    doNothing().when(cinemaRepository).deleteById(ID);
    when(cinemaRepository.findById(ID)).thenReturn(Optional.empty());

    Boolean result = cinemaService.delete(ID);

    assertTrue(result);
  }
}
