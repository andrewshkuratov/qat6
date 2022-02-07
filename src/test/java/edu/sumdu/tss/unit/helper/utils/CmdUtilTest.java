package edu.sumdu.tss.unit.helper.utils;

import static org.junit.jupiter.api.Assertions.*;

import edu.sumdu.tss.elephant.helper.utils.CmdUtil;
import org.junit.jupiter.api.Test;

public class CmdUtilTest {
    private static final String validAppName = "/System/Applications/TextEdit.app";
    private static final String invalidAppName = "asdasd";

    @Test
    void execValidCommand() {
        try {
            CmdUtil.exec(validAppName);
            assertTrue(true);
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    void execInvalidCommand() {
        try {
            CmdUtil.exec(invalidAppName);
            assertTrue(true);
        } catch (Exception e) {
            fail();
        }
    }
}
