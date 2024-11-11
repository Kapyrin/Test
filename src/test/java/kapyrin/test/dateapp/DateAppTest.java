package kapyrin.test.dateapp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DateAppTest {
    private DateApp dateApp;

    @BeforeEach
    public void setUp() {
        dateApp = new DateApp();
    }

    @Test
    @DisplayName("Test to valid format output")
    public void testReturnCurrentDayAndTIme() {
        String currentDayAndTIme = dateApp.returnCurrentDayAndTime();
        String checkValidFormat = "\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}";

        assertNotNull(currentDayAndTIme);
        assertTrue(currentDayAndTIme.matches(checkValidFormat));
    }


}