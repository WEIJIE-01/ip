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
     * @param tdStrings, tokens of string
     * @return LocalDateTime
     * @throws CustomException
     */
    public static LocalDateTime toLocalDate(String[] tdStrings) throws CustomException {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(
                    "[yyyy-MM-dd HH:mm]" +   // existing
                    "[yyyy-MM-dd]" +         // date only
                    "[dd/MM/yy HH:mm]" +     // new format with time
                    "[dd/MM/yy]"             // new format, date only
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