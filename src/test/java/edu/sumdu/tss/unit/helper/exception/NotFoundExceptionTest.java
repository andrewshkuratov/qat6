package edu.sumdu.tss.unit.helper.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;

import edu.sumdu.tss.elephant.helper.exception.NotFoundException;
import org.junit.jupiter.api.Test;

public class NotFoundExceptionTest {
    private static final Integer expectedCode = 404;

    @Test
    void getCode() {
        NotFoundException exception = new NotFoundException("dar");
        assertEquals(expectedCode, exception.getCode());
    }
}
