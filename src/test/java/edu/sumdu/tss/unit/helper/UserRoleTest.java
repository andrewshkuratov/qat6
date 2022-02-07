package edu.sumdu.tss.unit.helper;

import edu.sumdu.tss.elephant.helper.UserRole;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserRoleTest {
    @Test
    void anyoneUserRole() {
        assertEquals(0, UserRole.ANYONE.maxConnections());
        assertEquals(0, UserRole.ANYONE.maxDB());
        assertEquals(0, UserRole.ANYONE.maxStorage());
        assertEquals(0, UserRole.ANYONE.maxBackupsPerDB());
        assertEquals(0, UserRole.ANYONE.maxScriptsPerDB());
    }

    @Test
    void unchekedUserRole() {
        assertEquals(0, UserRole.UNCHEKED.maxConnections());
        assertEquals(0, UserRole.UNCHEKED.maxDB());
        assertEquals(0, UserRole.UNCHEKED.maxStorage());
        assertEquals(0, UserRole.UNCHEKED.maxBackupsPerDB());
        assertEquals(0, UserRole.UNCHEKED.maxScriptsPerDB());
    }

    @Test
    void basicUserRole() {
        assertEquals(5, UserRole.BASIC_USER.maxConnections());
        assertEquals(2, UserRole.BASIC_USER.maxDB());
        assertEquals(20 * FileUtils.ONE_MB, UserRole.BASIC_USER.maxStorage());
        assertEquals(1, UserRole.BASIC_USER.maxBackupsPerDB());
        assertEquals(2, UserRole.BASIC_USER.maxScriptsPerDB());
    }

    @Test
    void promotedUserRole() {
        assertEquals(5, UserRole.PROMOTED_USER.maxConnections());
        assertEquals(3, UserRole.PROMOTED_USER.maxDB());
        assertEquals(50 * FileUtils.ONE_MB, UserRole.PROMOTED_USER.maxStorage());
        assertEquals(5, UserRole.PROMOTED_USER.maxBackupsPerDB());
        assertEquals(5, UserRole.PROMOTED_USER.maxScriptsPerDB());
    }

    @Test
    void adminUserRole() {
        assertEquals(5, UserRole.ANYONE.maxConnections());
        assertEquals(100, UserRole.ANYONE.maxDB());
        assertEquals(50 * FileUtils.ONE_MB, UserRole.ANYONE.maxStorage());
        assertEquals(10, UserRole.ANYONE.maxBackupsPerDB());
        assertEquals(10, UserRole.ANYONE.maxScriptsPerDB());
    }

    @Test
    void byValue() {
        assertEquals(UserRole.ANYONE, UserRole.byValue(0));
        assertEquals(UserRole.UNCHEKED, UserRole.byValue(1));
        assertEquals(UserRole.BASIC_USER, UserRole.byValue(2));
        assertEquals(UserRole.PROMOTED_USER, UserRole.byValue(3));
        assertEquals(UserRole.ADMIN, UserRole.byValue(4));
    }
}
