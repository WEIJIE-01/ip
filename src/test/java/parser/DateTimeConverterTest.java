package parser;

import exception.CustomException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Tests DateTimeConverterTest by giving invalid Month
 */
public class DateTimeConverterTest {
    @Test
    public void toLocalDate_invalidDate_throwsError() {
        CustomException ex = assertThrows(
            CustomException.class,
            () -> DateTimeConverter.toLocalDate(new String[]{"2026-47-30"})
        );
        assertEquals("Invalid date time format! Input yyyy-MM-dd HH:mm", ex.getMessage());
    }
}