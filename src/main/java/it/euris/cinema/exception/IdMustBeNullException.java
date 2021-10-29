package it.euris.cinema.exception;

public class IdMustBeNullException extends RuntimeException {

  public IdMustBeNullException() {
    super("Id must be null. You sent a dto with an id already present");
  }
}
