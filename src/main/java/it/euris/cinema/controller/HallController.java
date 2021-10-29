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
import it.euris.cinema.data.dto.HallDto;
import it.euris.cinema.service.HallService;

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
}
