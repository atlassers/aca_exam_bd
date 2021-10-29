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
import it.euris.cinema.data.dto.TicketDto;
import it.euris.cinema.service.TicketService;

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
