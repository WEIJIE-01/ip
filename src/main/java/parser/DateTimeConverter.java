package parser;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import exception.CustomException;

/**
 * Converts datetime from String to LocalDate yyyy-MM-dd HH:mm
 */
public class DateTimeConverter {
    /**
     * Convert date time tokens into LocalDateTime
     *
     * @param tdStrings tokens of string
     * @return LocalDateTime
     * @throw CustomException
     */
    public static LocalDateTime toLocalDate(String[] tdStrings) throws CustomException {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(
                    "[yyyy-MM-dd HH:mm]"
                            + "[yyyy-MM-dd]"
                            + "[dd/MM/yy HH:mm]"
                            + "[dd/MM/yy]"
                    );
            if (tdStrings.length == 1) {
                String tdString = tdStrings[0] + " 23:59";
                return LocalDateTime.parse(tdString, formatter);
            }
            if (tdStrings.length == 2) {
                String tdString = String.join(" ", tdStrings);
                return LocalDateTime.parse(tdString, formatter);
            }
            throw new CustomException("Invalid date time format! Input dd/MM/yy HH:mm");

        } catch (DateTimeParseException e) {
            throw new CustomException("Invalid date time format! Input dd/MM/yy HH:mm");
        }
    }
}