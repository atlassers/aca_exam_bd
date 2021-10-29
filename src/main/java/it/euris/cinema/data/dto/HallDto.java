package it.euris.cinema.data.dto;

import it.euris.cinema.data.archetype.Dto;
import it.euris.cinema.data.model.Hall;
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
public class HallDto implements Dto {

	private String id;

	@Override
	public Hall toModel() {
    return Hall.builder().id(UT.toLong(id)).build();
	}
}
