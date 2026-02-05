package parser;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import exception.CustomException;

/**
 * Converts datetime from String to LocalDate yyyy-MM-dd HH:mm
 */
public class DateTimeConverter {
    // converts String date time to LocalDateTime
    public static LocalDateTime toLocalDate(String[] tdStrings) throws CustomException {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            if (tdStrings.length == 1) {
                String tdString = tdStrings[0] + " 23:59";
                return LocalDateTime.parse(tdString, formatter);
            }
            if (tdStrings.length == 2) {
                String tdString = String.join(" ", tdStrings);
                return LocalDateTime.parse(tdString, formatter);
            }
            throw new CustomException("Invalid date time format! Input yyyy-MM-dd HH:mm");

        } catch (DateTimeParseException e) {
            throw new CustomException("Invalid date time format! Input yyyy-MM-dd HH:mm");
        }
    }
}