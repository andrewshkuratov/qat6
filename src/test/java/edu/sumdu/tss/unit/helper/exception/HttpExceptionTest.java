package edu.sumdu.tss.unit.helper.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;

import edu.sumdu.tss.elephant.helper.exception.HttpException;
import org.junit.jupiter.api.Test;

public class HttpExceptionTest {
    private static final Integer expectedCode = 500;

    @Test
    void getCode() {
        HttpException exception = new HttpException();
        assertEquals(expectedCode, exception.getCode());
    }
}
