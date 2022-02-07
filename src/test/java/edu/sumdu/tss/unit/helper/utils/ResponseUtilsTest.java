package edu.sumdu.tss.unit.helper.utils;

import edu.sumdu.tss.elephant.helper.utils.ResponseUtils;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

public class ResponseUtilsTest {
    private static final String status = "status";
    private static final String message = "message";

    private static final String success = "This is success message!";
    private static final String error = "This is success message!";
    private static final String answer = "Ok";
    private static final String title = "Error";

    @Test
    void success() {
        HashMap<String, String> result = (HashMap<String, String>) ResponseUtils.success(success);
        assertEquals(answer, result.get(status));
        assertEquals(success, result.get(message));
    }

    @Test
    void error() {
        HashMap<String, String> result = (HashMap<String, String>) ResponseUtils.error(error);
        assertEquals(title, result.get(status));
        assertEquals(error, result.get(message));
    }
}
