package it.euris.cinema.controller;

import it.euris.cinema.data.dto.TicketDto;
import it.euris.cinema.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tickets")
public class TicketController {

  @Autowired private TicketService ticketService;

  @GetMapping("/v1")
  public List<TicketDto> getAll() {
    return ticketService.getAll();
  }

  @GetMapping("/v1/{id}")
  public TicketDto get(@PathVariable("id") Long id) {
    return ticketService.get(id);
  }

  @PostMapping("/v1")
  public TicketDto add(@RequestBody TicketDto ticketDto) {
    return ticketService.add(ticketDto);
  }

  @PutMapping("/v1")
  public TicketDto update(@RequestBody TicketDto ticketDto) {
    return ticketService.update(ticketDto);
  }

  @DeleteMapping("/v1/{id}")
  public Boolean delete(@PathVariable("id") Long id) {
    return ticketService.delete(id);
  }
}
