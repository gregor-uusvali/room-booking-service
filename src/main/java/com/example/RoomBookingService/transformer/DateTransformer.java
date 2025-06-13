package com.example.RoomBookingService.transformer;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Component;

@Component
public class DateTransformer {

  public String transformLocalDateToString(LocalDate date, String pattern) {
    if (date == null) {
      return null;
    }
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
    return date.format(formatter);
  }

  public LocalDate transformStringToLocalDate(String dateString, String pattern) {
    if (dateString == null || dateString.isEmpty()) {
      return null;
    }

    dateString = normalizeMonthString(dateString);
    if (dateString.split("-").length == 2 && pattern.equals("yyyy-MM-dd")) {
      dateString = dateString + "-01";
    }
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
    return LocalDate.parse(dateString, formatter);
  }

  public String getCurrentMonthString() {
    return transformLocalDateToString(LocalDate.now().withDayOfMonth(1), "yyyy-MM");
  }

  // New method to handle flexible month parsing
  public LocalDate parseMonthString(String month) {
    if (month == null || month.isEmpty()) {
      return null;
    }

    // Normalize the month string to "yyyy-MM" format
    String normalizedMonth = normalizeMonthString(month);
    return transformStringToLocalDate(normalizedMonth + "-01", "yyyy-MM-dd");
  }

  private String normalizeMonthString(String month) {
    String[] parts = month.split("-");
    System.out.println(month);
    if (parts.length != 2) {
      throw new IllegalArgumentException("Invalid month format. Expected 'yyyy-M' or 'yyyy-MM'");
    }

    String year = parts[0];
    String monthPart = parts[1];

    // Pad month with leading zero if needed
    if (monthPart.length() == 1) {
      monthPart = "0" + monthPart;
    }

    return year + "-" + monthPart;
  }
}
