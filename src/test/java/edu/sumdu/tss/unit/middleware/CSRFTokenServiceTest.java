package edu.sumdu.tss.unit.middleware;

import edu.sumdu.tss.elephant.middleware.CSRFTokenService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CSRFTokenServiceTest {
    private static final String session = "dsajsaknda";

    @Test
    void getSiteWideToken() {
        assertEquals("test token", CSRFTokenService.getSiteWideToken());
    }

    @Test
    void validateTokenValid() {
        String token = CSRFTokenService.generateToken(session);
        assertTrue(CSRFTokenService.validateToken(token, session));
    }

    @Test
    void validateTokenInvalid() {
        String token = CSRFTokenService.generateToken(session);

        long time = System.currentTimeMillis() + 100;
        int splitter = token.lastIndexOf("-");
        String wrongToken = token.substring(0, splitter) + '-' + time;

        assertFalse(CSRFTokenService.validateToken(wrongToken, session));
    }
}
