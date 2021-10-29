package it.euris.cinema.controller;

import it.euris.cinema.data.dto.FilmDto;
import it.euris.cinema.data.model.Film;
import it.euris.cinema.repository.FilmRepository;
import it.euris.cinema.service.FilmService;
import it.euris.cinema.service.impl.FilmServiceImpl;
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
public class FilmControllerTest {

  private FilmService filmService;

  @Mock FilmRepository filmRepository;

  @BeforeEach
  void initialize() {
    filmService = new FilmServiceImpl(filmRepository);
  }

  @Test
  @DisplayName("Given a list of films to get When getAll Then return those films")
  void getAll() {
    List<Film> mockedFilms = TestSupport.createFilmList();
    when(filmRepository.findAll()).thenReturn(mockedFilms);

    List<FilmDto> result = filmService.getAll();

    assertEquals(mockedFilms.size(), result.size());
    for (int i = 0; i < mockedFilms.size(); i++)
      assertEquals(mockedFilms.get(i).toDto(), result.get(i));
  }

  @Test
  @DisplayName("Given a film to get When get Then return this film")
  void get() {
    final Long ID = 1L;
    Film mockedFilm = TestSupport.createFilm(ID);
    when(filmRepository.findById(ID)).thenReturn(Optional.of(mockedFilm));

    FilmDto result = filmService.get(ID);

    assertEquals(mockedFilm.toDto(), result);
  }

  @Test
  @DisplayName("Given a film to add When add Then add a film")
  void add() {
    Film filmToAdd = TestSupport.createFilm(null);
    Film filmToReturn = TestSupport.createFilm(1L);
    when(filmRepository.save(any())).thenReturn(filmToReturn);

    FilmDto result = filmService.add(filmToAdd.toDto());

    assertEquals(filmToReturn.toDto(), result);
  }

  @Test
  @DisplayName("Given a film to update When update Then update the film")
  void update() {
    Film filmToUpdate = TestSupport.createFilm(1L);
    Film filmToReturn = TestSupport.createFilm(2L);
    when(filmRepository.save(any())).thenReturn(filmToReturn);

    FilmDto result = filmService.update(filmToUpdate.toDto());

    assertEquals(filmToReturn.toDto(), result);
  }

  @Test
  @DisplayName("Given a film to delete When delete Then delete the film")
  void delete() {
    final Long ID = 1L;
    doNothing().when(filmRepository).deleteById(ID);
    when(filmRepository.findById(ID)).thenReturn(Optional.empty());

    Boolean result = filmService.delete(ID);

    assertTrue(result);
  }
}
