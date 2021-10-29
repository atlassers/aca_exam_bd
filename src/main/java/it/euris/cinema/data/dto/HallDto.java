package it.euris.cinema.data.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import it.euris.cinema.data.archetype.Dto;
import it.euris.cinema.data.model.*;
import it.euris.cinema.utils.UT;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

/**
 * @author Busterna Davide
 * @since 2021-10-29
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HallDto implements Dto {

  private String id;
  private String maxSpectators;
  private String filmId;
  private String cinemaId;

  @Override
  public Hall toModel() {
    Hall hall = Hall.builder().id(UT.toLong(id)).maxSpectators(UT.toInteger(maxSpectators)).build();

    if (filmId != null) hall.setFilm(Film.builder().id(UT.toLong(filmId)).build());

    if (cinemaId != null) hall.setCinema(Cinema.builder().id(UT.toLong(cinemaId)).build());

    return hall;
  }
}
