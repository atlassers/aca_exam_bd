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
import it.euris.cinema.data.dto.SpectatorDto;
import it.euris.cinema.service.SpectatorService;

@RestController
@RequestMapping("/spectators")
public class SpectatorController {

	@Autowired private SpectatorService spectatorService;

	@GetMapping("/v1")
	public List<SpectatorDto> getAll() {
		return spectatorService.getAll();
	}

	@GetMapping("/v1/{id}")
	public SpectatorDto get(@PathVariable("id") Long id) {
		return spectatorService.get(id);
	}

	@PostMapping("/v1")
	public SpectatorDto add(@RequestBody SpectatorDto spectatorDto) {
		return spectatorService.add(spectatorDto);
	}

	@PutMapping("/v1")
	public SpectatorDto update(@RequestBody SpectatorDto spectatorDto) {
		return spectatorService.update(spectatorDto);
	}

	@DeleteMapping("/v1/{id}")
	public Boolean delete(@PathVariable("id") Long id) {
		return spectatorService.delete(id);
	}
}
