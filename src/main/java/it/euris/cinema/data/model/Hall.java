package it.euris.cinema.data.model;

import it.euris.cinema.data.archetype.Model;
import it.euris.cinema.data.dto.HallDto;
import it.euris.cinema.utils.UT;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.List;

/**
 * @author Busterna Davide
 * @since 2021-10-29
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "hall")
@SQLDelete(sql = "UPDATE Hall SET deleted = true WHERE id=?")
@Where(clause = "deleted = false")
public class Hall implements Model {

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "deleted")
  @Builder.Default
  private Boolean deleted = false;

  @Column(name = "max_spectators")
  private Integer maxSpectators;

  @ManyToOne
  @JoinColumn(name = "cinema_id", nullable = false)
  private Cinema cinema;

  @OneToOne
  @JoinColumn(name = "film_id", nullable = false)
  private Film film;

  @OneToMany(mappedBy = "hall")
  private List<Ticket> tickets;

  @Override
  public HallDto toDto() {
    HallDto hallDto =
        HallDto.builder()
            .id(UT.toString(id))
            .maxSpectators(UT.toString(maxSpectators))
            .cinemaId(UT.toString(cinema.getId()))
            .build();

    if (film != null) hallDto.setFilmId(UT.toString(film.getId()));

    return hallDto;
  }
}
