package utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DataUtils {
  private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

  public static LocalDate parseLocalDate(String dateString) {
    try {
      return LocalDate.parse(dateString, DATE_FORMATTER);
    } catch (DateTimeParseException e) {
      // Lidar com a exceção caso a data não esteja no formato esperado
      e.printStackTrace();
      return null;
    }
  }
}
