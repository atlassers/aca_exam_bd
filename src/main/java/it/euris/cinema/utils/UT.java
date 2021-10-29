package it.euris.cinema.utils;

import java.time.Instant;

/**
 * @author Busterna Davide
 * @since 2021-10-29
 */
public class UT {

  public static Long toLong(String value) {
    return value == null ? null : Long.parseLong(value);
  }

  public static Integer toInteger(String value) {
    return value == null ? null : Integer.parseInt(value);
  }

  public static Double toDouble(String value) {
    return value == null ? null : Double.parseDouble(value);
  }

  public static Instant toInstant(String value) {
    return value == null ? null : Instant.parse(value);
  }

  public static String toString(Object o) {
    return o == null ? null : o.toString();
  }
}
