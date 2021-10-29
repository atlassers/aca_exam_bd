package it.euris.cinema.exception;

import it.euris.cinema.data.model.Film;

/**
 * @author Busterna Davide
 * @since 2021-10-29
 */
public class FilmVietatoAiMinoriException extends Exception {

	public FilmVietatoAiMinoriException(){
		super("Il film è vietato ai minori.");
	}
}
