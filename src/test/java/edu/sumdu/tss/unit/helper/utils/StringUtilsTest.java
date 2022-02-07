package edu.sumdu.tss.unit.helper.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;

import edu.sumdu.tss.elephant.helper.utils.StringUtils;
import org.junit.jupiter.api.Test;

public class StringUtilsTest {
    
    private static final String toEdit = "Test string example";
    private static final String editedStringfirst = "Test  ing example";
    private static final String editedStringSecond = "Test string exa e";

    @Test
    void randomAlphaString() {
        final int size = 15;
        String alphaString = StringUtils.randomAlphaString(15);
        assertEquals(size, alphaString.length());
    }

    @Test
    void replaceLast() {
        assertEquals(editedStringfirst, StringUtils.replaceLast(toEdit, "str", " "));
        assertEquals(editedStringSecond, StringUtils.replaceLast(toEdit, "mpl", " "));
    }
}
