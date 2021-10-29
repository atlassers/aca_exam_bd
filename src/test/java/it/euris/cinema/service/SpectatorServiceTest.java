package it.euris.cinema.service;

import it.euris.cinema.data.dto.SpectatorDto;
import it.euris.cinema.data.model.Spectator;
import it.euris.cinema.repository.SpectatorRepository;
import it.euris.cinema.service.SpectatorService;
import it.euris.cinema.service.impl.SpectatorServiceImpl;
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
public class SpectatorServiceTest {

  private SpectatorService spectatorService;

  @Mock SpectatorRepository spectatorRepository;

  @BeforeEach
  void initialize() {
    spectatorService = new SpectatorServiceImpl(spectatorRepository);
  }

  @Test
  @DisplayName("Given a list of spectators to get When getAll Then return those spectators")
  void getAll() {
    List<Spectator> mockedSpectators = TestSupport.createSpectatorList();
    when(spectatorRepository.findAll()).thenReturn(mockedSpectators);

    List<SpectatorDto> result = spectatorService.getAll();

    assertEquals(mockedSpectators.size(), result.size());
    for (int i = 0; i < mockedSpectators.size(); i++)
      assertEquals(mockedSpectators.get(i).toDto(), result.get(i));
  }

  @Test
  @DisplayName("Given a spectator to get When get Then return this spectator")
  void get() {
    final Long ID = 1L;
    Spectator mockedSpectator = TestSupport.createSpectator(ID);
    when(spectatorRepository.findById(ID)).thenReturn(Optional.of(mockedSpectator));

    SpectatorDto result = spectatorService.get(ID);

    assertEquals(mockedSpectator.toDto(), result);
  }

  @Test
  @DisplayName("Given a spectator to add When add Then add a spectator")
  void add() {
    Spectator spectatorToAdd = TestSupport.createSpectator(null);
    Spectator spectatorToReturn = TestSupport.createSpectator(1L);
    when(spectatorRepository.save(any())).thenReturn(spectatorToReturn);

    SpectatorDto result = spectatorService.add(spectatorToAdd.toDto());

    assertEquals(spectatorToReturn.toDto(), result);
  }

  @Test
  @DisplayName("Given a spectator to update When update Then update the spectator")
  void update() {
    Spectator spectatorToUpdate = TestSupport.createSpectator(1L);
    Spectator spectatorToReturn = TestSupport.createSpectator(2L);
    when(spectatorRepository.save(any())).thenReturn(spectatorToReturn);

    SpectatorDto result = spectatorService.update(spectatorToUpdate.toDto());

    assertEquals(spectatorToReturn.toDto(), result);
  }

  @Test
  @DisplayName("Given a spectator to delete When delete Then delete the spectator")
  void delete() {
    final Long ID = 1L;
    doNothing().when(spectatorRepository).deleteById(ID);
    when(spectatorRepository.findById(ID)).thenReturn(Optional.empty());

    Boolean result = spectatorService.delete(ID);

    assertTrue(result);
  }
}
