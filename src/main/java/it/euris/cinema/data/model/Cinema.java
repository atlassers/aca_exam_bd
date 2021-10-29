package it.euris.cinema.data.model;

import it.euris.cinema.data.archetype.Model;
import it.euris.cinema.data.dto.CinemaDto;
import it.euris.cinema.utils.UT;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.ArrayList;
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
@Table(name = "cinema")
@SQLDelete(sql = "UPDATE Cinema SET deleted = true WHERE id=?")
@Where(clause = "deleted = false")
public class Cinema implements Model {

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "deleted")
  @Builder.Default
  private Boolean deleted = false;

  @OneToMany(mappedBy = "cinema")
  @Builder.Default
  private List<Hall> halls = new ArrayList<>();

  @Override
  public CinemaDto toDto() {
    return CinemaDto.builder().id(UT.toString(id)).build();
  }
}
