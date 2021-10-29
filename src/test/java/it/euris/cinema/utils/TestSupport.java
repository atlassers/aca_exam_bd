package it.euris.cinema.utils;

import it.euris.cinema.data.model.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Busterna Davide
 * @since 2021-10-29
 */
public class TestSupport {

  public static Cinema createCinema(Long id) {
    return Cinema.builder().id(id).build();
  }

  public static List<Cinema> createCinemaList() {
    List<Cinema> list = new ArrayList<>();
    list.add(createCinema(1L));
    list.add(createCinema(2L));
    return list;
  }

  public static Film createFilm(Long id) {
    return Film.builder().id(id).build();
  }

  public static List<Film> createFilmList() {
    List<Film> list = new ArrayList<>();
    list.add(createFilm(1L));
    list.add(createFilm(2L));
    return list;
  }

  public static Hall createHall(Long id) {
    return Hall.builder().id(id).build();
  }

  public static List<Hall> createHallList() {
    List<Hall> list = new ArrayList<>();
    list.add(createHall(1L));
    list.add(createHall(2L));
    return list;
  }

  public static Spectator createSpectator(Long id) {
    return Spectator.builder().id(id).build();
  }

  public static List<Spectator> createSpectatorList() {
    List<Spectator> list = new ArrayList<>();
    list.add(createSpectator(1L));
    list.add(createSpectator(2L));
    return list;
  }

  public static Ticket createTicket(Long id) {
    return Ticket.builder().id(id).build();
  }

  public static List<Ticket> createTicketList() {
    List<Ticket> list = new ArrayList<>();
    list.add(createTicket(1L));
    list.add(createTicket(2L));
    return list;
  }
}
