package it.euris.cinema.data.model;

import it.euris.cinema.data.archetype.Model;
import it.euris.cinema.data.dto.SpectatorDto;
import it.euris.cinema.utils.UT;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.time.Instant;

/**
 * @author Busterna Davide
 * @since 2021-10-29
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "spectator")
@SQLDelete(sql = "UPDATE Spectator SET deleted = true WHERE id=?")
@Where(clause = "deleted = false")
public class Spectator implements Model {

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "deleted")
  @Builder.Default
  private Boolean deleted = false;

  @Column(name = "id_spectator")
  private String idSpectator;

  @Column(name = "spectator_name")
  private String spectatorName;

  @Column(name = "spectator_surname")
  private String spectatorSurname;

  @Column(name = "date_of_birth", nullable = false)
  private Instant dateOfBirth;

  @OneToOne
  @JoinColumn(name = "ticket_id")
  private Ticket ticket;

  @Override
  public SpectatorDto toDto() {
    return SpectatorDto.builder()
        .id(UT.toString(id))
        .idSpectator(idSpectator)
        .spectatorName(spectatorName)
        .spectatorSurname(spectatorSurname)
        .dateOfBirth(UT.toString(dateOfBirth))
        .build();
  }
}
