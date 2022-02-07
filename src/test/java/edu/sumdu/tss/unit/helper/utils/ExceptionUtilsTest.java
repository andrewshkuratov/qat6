package edu.sumdu.tss.unit.helper.utils;

import edu.sumdu.tss.elephant.helper.utils.ExceptionUtils;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

public class ExceptionUtilsTest {
    private static final String exceptionMessage = "Some message";

    @Test
    void isSQLUniqueExceptionPresent() {
        Throwable exception = new RuntimeException(new SQLException(exceptionMessage));
        assertTrue(ExceptionUtils.isSQLUniqueException(exception));
    }

    @Test
    void isSQLUniqueExceptionNoPresent() {
        Throwable exception = new RuntimeException(new SQLException("dmsalds"));
        assertFalse(ExceptionUtils.isSQLUniqueException(exception));
    }
}
