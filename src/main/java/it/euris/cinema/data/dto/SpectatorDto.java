package it.euris.cinema.data.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import it.euris.cinema.data.archetype.Dto;
import it.euris.cinema.data.model.Spectator;
import it.euris.cinema.utils.UT;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;

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

  @JsonIgnore
  public Integer getAge() {
    ZoneId zoneId = ZoneId.of("UTC");
    Integer yearOfBirth = UT.toInstant(dateOfBirth).atZone(zoneId).get(ChronoField.YEAR);
    Integer currentYear = Instant.now().atZone(zoneId).get(ChronoField.YEAR);
    return currentYear - yearOfBirth;
  }

  @JsonIgnore
  public Boolean isMatureFor(Integer years) {
    return getAge() >= years;
  }

  @JsonIgnore
  public Double getDiscount() {
    Integer age = getAge();
    if (age > 70) return 10.0;
    else if (age < 5) return 50.0;
    return 0.0;
  }

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
