package it.euris.cinema.controller;

import it.euris.cinema.data.dto.HallDto;
import it.euris.cinema.data.dto.TicketDto;
import it.euris.cinema.service.HallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Busterna Davide
 * @since 2021-10-29
 */
@RestController
@RequestMapping("/halls")
public class HallController {

  @Autowired private HallService hallService;

  @GetMapping("/v1")
  public List<HallDto> getAll() {
    return hallService.getAll();
  }

  @GetMapping("/v1/{id}")
  public HallDto get(@PathVariable("id") Long id) {
    return hallService.get(id);
  }

  @PostMapping("/v1")
  public HallDto add(@RequestBody HallDto hallDto) {
    return hallService.add(hallDto);
  }

  @PutMapping("/v1")
  public HallDto update(@RequestBody HallDto hallDto) {
    return hallService.update(hallDto);
  }

  @DeleteMapping("/v1/{id}")
  public Boolean delete(@PathVariable("id") Long id) {
    return hallService.delete(id);
  }

  @PostMapping("/v1/{hallId}/create-ticket/{spectatorId}")
  public TicketDto createTicket(
      @PathVariable("hallId") Long hallId, @PathVariable("spectatorId") Long spectatorId) throws Exception {
    return hallService.createTicket(hallId, spectatorId);
  }

  @DeleteMapping("/v1/{id}/clean")
  public void clean(@PathVariable("id") Long id) {
    hallService.clean(id);
  }

  @GetMapping("/v1/{id}/getProfit")
  public Double getProfit(@PathVariable("id") Long id) {
    return hallService.getProfit(id);
  }
}
