package it.euris.cinema.data.model;

import it.euris.cinema.data.archetype.Model;
import it.euris.cinema.data.dto.FilmDto;
import it.euris.cinema.data.dto.SpectatorDto;
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
@Table(name = "film")
@SQLDelete(sql = "UPDATE Film SET deleted = true WHERE id=?")
@Where(clause = "deleted = false")
public class Film implements Model {

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "deleted")
  @Builder.Default
  private Boolean deleted = false;

  @Column(name = "title")
  private String title;

  @Column(name = "author")
  private String author;

  @Column(name = "producer")
  private String producer;

  @Column(name = "genre")
  private String genre;

  @Column(name = "minimum_age")
  private Integer minimumAge;

  @Column(name = "duration")
  private Integer duration;

  @Column(name = "price", nullable = false)
  private Double price;

  @OneToOne(mappedBy = "film")
  private Hall hall;

  @Override
  public FilmDto toDto() {
    return FilmDto.builder()
        .id(UT.toString(id))
        .title(title)
        .author(author)
        .producer(producer)
        .genre(genre)
        .minimumAge(UT.toString(minimumAge))
        .duration(UT.toString(duration))
        .price(UT.toString(price))
        .build();
  }
}
