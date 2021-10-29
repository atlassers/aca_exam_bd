package it.euris.cinema.data.model;

import it.euris.cinema.data.archetype.Dto;
import it.euris.cinema.data.archetype.Model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
@Table(name = "cinema")
public class Cinema implements Model {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "deleted")
	@Builder.Default
	private Boolean deleted = false;

	@Override
	public Dto toDto() {
    return null;
	}
}
