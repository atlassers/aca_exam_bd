package it.euris.cinema.controller;

import it.euris.cinema.data.dto.CinemaDto;
import it.euris.cinema.service.CinemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Busterna Davide
 * @since 2021-10-29
 */
@RestController
@RequestMapping("/cinemas")
public class CinemaController {

  @Autowired private CinemaService cinemaService;

  @GetMapping("/v1")
  public List<CinemaDto> getAll() {
    return cinemaService.getAll();
  }

  @GetMapping("/v1/{id}")
  public CinemaDto get(@PathVariable("id") Long id) {
    return cinemaService.get(id);
  }

  @PostMapping("/v1")
  public CinemaDto add(@RequestBody CinemaDto cinemaDto) {
    return cinemaService.add(cinemaDto);
  }

  @PutMapping("/v1")
  public CinemaDto update(@RequestBody CinemaDto cinemaDto) {
    return cinemaService.update(cinemaDto);
  }

  @DeleteMapping("/v1/{id}")
  public Boolean delete(@PathVariable("id") Long id) {
    return cinemaService.delete(id);
  }
}
