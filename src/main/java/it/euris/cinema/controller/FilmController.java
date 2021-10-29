package it.euris.cinema.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import it.euris.cinema.data.dto.FilmDto;
import it.euris.cinema.service.FilmService;

@RestController
@RequestMapping("/films")
public class FilmController {

  @Autowired private FilmService filmService;

  @GetMapping("/v1")
  public List<FilmDto> getAll() {
    return filmService.getAll();
  }

  @GetMapping("/v1/{id}")
  public FilmDto get(@PathVariable("id") Long id) {
    return filmService.get(id);
  }

  @PostMapping("/v1")
  public FilmDto add(@RequestBody FilmDto filmDto) {
    return filmService.add(filmDto);
  }

  @PutMapping("/v1")
  public FilmDto update(@RequestBody FilmDto filmDto) {
    return filmService.update(filmDto);
  }

  @DeleteMapping("/v1/{id}")
  public Boolean delete(@PathVariable("id") Long id) {
    return filmService.delete(id);
  }
}
