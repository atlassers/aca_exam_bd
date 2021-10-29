package it.euris.cinema.exception;

/**
 * @author Busterna Davide
 * @since 2021-10-29
 */
public class SalaAlCompletoException extends Exception {

	public SalaAlCompletoException() {
		super("La sala è al completo.");
	}
}
