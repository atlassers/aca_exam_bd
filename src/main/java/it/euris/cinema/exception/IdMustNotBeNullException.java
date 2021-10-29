package it.euris.cinema.exception;

public class IdMustNotBeNullException extends RuntimeException {

  public IdMustNotBeNullException() {
    super("Id must not be null.");
  }
}
