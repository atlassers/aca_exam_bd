package it.euris.cinema.data.dto;

import it.euris.cinema.data.archetype.Dto;
import it.euris.cinema.data.model.Film;
import it.euris.cinema.utils.UT;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Busterna Davide
 * @since 2021-10-29
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FilmDto implements Dto {

  private String id;
  private String title;
  private String author;
  private String producer;
  private String genre;
  private String minimumAge;
  private String duration;

  @Override
  public Film toModel() {
    return Film.builder()
        .id(UT.toLong(id))
        .title(title)
        .author(author)
        .producer(producer)
        .genre(genre)
        .minimumAge(UT.toInteger(minimumAge))
        .duration(UT.toInteger(duration))
        .build();
  }
}
