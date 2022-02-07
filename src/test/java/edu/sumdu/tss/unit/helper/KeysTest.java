package edu.sumdu.tss.unit.helper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.File;

import edu.sumdu.tss.elephant.helper.Keys;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class KeysTest {

    @BeforeAll
    static void setUp() {
        Keys.loadParams(new File("config.properties"));
    }

    @Test
    void isProduction() {
        assertFalse(Keys.isProduction());
    }

    @Test
    void get() {
        try {
            String parameter = "EMAIL.HOST";
            String expectedResult = "smtp.gmail.com";
            assertEquals(expectedResult, Keys.get(parameter));
        } catch(Throwable error) {
            fail();
        }
    }
}
