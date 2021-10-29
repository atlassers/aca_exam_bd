package it.euris.cinema.data.dto;

import it.euris.cinema.data.archetype.Dto;
import it.euris.cinema.data.model.Ticket;
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
public class TicketDto implements Dto {

  private String id;

  @Override
  public Ticket toModel() {
    return Ticket.builder().id(UT.toLong(id)).build();
  }
}
