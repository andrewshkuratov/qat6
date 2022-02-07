package edu.sumdu.tss.unit.model;

import edu.sumdu.tss.elephant.helper.exception.NotFoundException;
import edu.sumdu.tss.elephant.model.Script;
import edu.sumdu.tss.elephant.model.ScriptService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ScriptServiceTest {
    private static final String dbScripts = "dbScripts";
    private static final String dbNoScripts = "dbNoScripts";
    private static final Integer id = 4123141;
    private static final Integer dbUnreal = 231332;

    @Test
    void listWithScripts() {
        assertFalse(ScriptService.list(dbScripts).isEmpty());
    }

    @Test
    void listWithoutScripts() {
        assertTrue(ScriptService.list(dbNoScripts).isEmpty());
    }

    @Test
    void byIdExist() {
        Script script = ScriptService.byId(id);
        assertNotNull(script);
    }

    @Test
    void byIdNotExist() {
        assertThrows(NotFoundException.class, () -> {ScriptService.byId(dbUnreal);});
    }
}
