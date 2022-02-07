package edu.sumdu.tss.unit.helper.sql;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

import edu.sumdu.tss.elephant.helper.sql.ScriptReader;
import org.junit.jupiter.api.Test;

public class ScriptReaderTest {
    private static final String validScriptPath = "scriptPath";
    private static final String invalidScriptPath = "invalidScriptPath";

    @Test
    void readStatementNotEmpty() {
        try (ScriptReader sr = new ScriptReader(new BufferedReader(new FileReader(validScriptPath)))) {
            assertNotNull(sr.readStatement());
        } catch (FileNotFoundException e) {
            fail();
        }
    }

    @Test
    void readStatementEmpty() {
        try (ScriptReader sr = new ScriptReader(new BufferedReader(new FileReader(invalidScriptPath)))) {
            assertNull(sr.readStatement());
        } catch (FileNotFoundException e) {
            fail();
        }
    }
}
