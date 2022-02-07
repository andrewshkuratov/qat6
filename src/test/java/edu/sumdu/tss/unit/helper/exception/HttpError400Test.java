package edu.sumdu.tss.unit.helper.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;

import edu.sumdu.tss.elephant.helper.exception.HttpError400;
import org.junit.jupiter.api.Test;

public class HttpError400Test {
    private static final Integer expectedCode = 400;

    @Test
    void getCode() {
        HttpError400 error = new HttpError400();
        assertEquals(expectedCode, error.getCode());
    }
}
