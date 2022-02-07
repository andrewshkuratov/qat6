package edu.sumdu.tss.unit.helper.utils;

import edu.sumdu.tss.elephant.helper.Keys;
import edu.sumdu.tss.elephant.helper.utils.MessageBundle;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.text.MessageFormat;

import static org.junit.jupiter.api.Assertions.*;

public class MessageBundleTest {
    private static final String ukraineLanguage = "UK";
    private static final String englishLanguage = "EN";
    private static final String messageName ="validation.mail.invalid";
    private static final String invalidMessageName ="validation.mail.invalid22";
    private static final String ukrainianMessageName ="Це дійсна пошта?";
    private static final String englishMessageName ="Is it a valid mail?";
    private static final String noMessageFound ="No message found";
    private static final Object[] objects = new Object[] {"sdf", "dfsd", "wdwqwe"};

    @BeforeAll
    static void setUp() {
        Keys.loadParams(new File("config.properties"));
    }

    @Test
    void getUkValid() {
        MessageBundle messageBundle = new MessageBundle(ukraineLanguage);
        assertEquals(ukrainianMessageName, messageBundle.get(messageName));
    }

    @Test
    void getUkInvalid() {
        MessageBundle messageBundle = new MessageBundle(ukraineLanguage);
        assertTrue(messageBundle.get(invalidMessageName).contains(noMessageFound));
    }

    @Test
    void getEnValid() {
        MessageBundle messageBundle = new MessageBundle(englishLanguage);
        assertEquals(englishMessageName, messageBundle.get(messageName));
    }

    @Test
    void getEnInvalid() {
        MessageBundle messageBundle = new MessageBundle(englishLanguage);
        assertTrue(messageBundle.get(invalidMessageName).contains(noMessageFound));
    }

    @Test
    void getMultipleValidation() {
        MessageBundle messageBundle = new MessageBundle(englishLanguage);
        String result = messageBundle.get(englishMessageName, objects);
        String expectedResult = MessageFormat.format(messageBundle.get(englishMessageName), objects);
        assertEquals(expectedResult, result);
    }
}
