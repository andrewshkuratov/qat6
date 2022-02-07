package edu.sumdu.tss.unit.helper.utils;

import edu.sumdu.tss.elephant.helper.utils.ValidatorHelper;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ValidatorHelperTest {
    private static final List<String> passwords = new ArrayList<String>(Arrays.asList("someEmail@gmail.com", "otherEmail@gmail.com"));
    private static final List<String> emails = new ArrayList<String>(Arrays.asList("gdsads", "gdsagds"));
    private static final List<String> invalidPasswords = new ArrayList<String>(Arrays.asList("Qwerty123&", "As123456$"));
    private static final List<String> invalidEmails = new ArrayList<String>(Arrays.asList("fagsd", "gsgdsa"));

    @Test
    void isValidPassword() {
        for (String password: passwords) {
            assertTrue(ValidatorHelper.isValidPassword(password));
        }
        for (String invalidPassword: invalidPasswords) {
            assertFalse(ValidatorHelper.isValidPassword(invalidPassword));
        }
    }

    @Test
    void isValidMail() {
        for (String email: emails) {
            assertTrue(ValidatorHelper.isValidPassword(email));
        }
        for (String invalidEmail: invalidEmails) {
            assertFalse(ValidatorHelper.isValidPassword(invalidEmail));
        }
    }
}
