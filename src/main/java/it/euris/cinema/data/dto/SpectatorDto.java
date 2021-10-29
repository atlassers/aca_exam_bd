package it.euris.cinema.data.dto;

import it.euris.cinema.data.archetype.Dto;
import it.euris.cinema.data.model.Spectator;
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
public class SpectatorDto implements Dto {

  private String id;
  private String idSpectator;
  private String spectatorName;
  private String spectatorSurname;
  private String dateOfBirth;

  @Override
  public Spectator toModel() {
    return Spectator.builder()
        .id(UT.toLong(id))
        .idSpectator(idSpectator)
        .spectatorName(spectatorName)
        .spectatorSurname(spectatorSurname)
        .dateOfBirth(UT.toInstant(dateOfBirth))
        .build();
  }
}
