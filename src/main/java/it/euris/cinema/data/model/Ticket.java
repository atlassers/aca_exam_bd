package it.euris.cinema.data.model;

import it.euris.cinema.data.archetype.Model;
import it.euris.cinema.data.dto.TicketDto;
import it.euris.cinema.utils.UT;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

/**
 * @author Busterna Davide
 * @since 2021-10-29
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "ticket")
@SQLDelete(sql = "UPDATE Ticket SET deleted = true WHERE id=?")
@Where(clause = "deleted = false")
public class Ticket implements Model {

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "deleted")
  @Builder.Default
  private Boolean deleted = false;

  @Column(name = "hall_position")
  private String hallPosition;

  @Column(name = "price")
  private Double price;

  @OneToOne(mappedBy = "ticket")
  private Spectator spectator;

  @ManyToOne
  @JoinColumn(name = "hall_id", nullable = false)
  private Hall hall;

  @Override
  public TicketDto toDto() {
    return TicketDto.builder()
        .id(UT.toString(id))
        .hallPosition(hallPosition)
        .price(UT.toString(price))
        .build();
  }
}
