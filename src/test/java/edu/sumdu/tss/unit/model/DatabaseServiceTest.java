package edu.sumdu.tss.unit.model;

import edu.sumdu.tss.elephant.helper.Keys;
import edu.sumdu.tss.elephant.helper.exception.AccessRestrictedException;
import edu.sumdu.tss.elephant.helper.exception.NotFoundException;
import edu.sumdu.tss.elephant.model.Database;
import edu.sumdu.tss.elephant.model.DatabaseService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

public class DatabaseServiceTest {
    private static final String realDbName = "realDbName";
    private static final String dbNameCreate = "dbNameCreate";
    private static final String dbNameDrop = "dbNameDrop";
    private static final String unrealDbName = "unrealDbName";
    private static final String owner = "owner";
    private static final Integer size = 2000;
    private static final String ownerUnreal = "NOT_EX_OWNER";

    @BeforeAll
    static void setUp() {
        DatabaseService.create(realDbName, owner, owner);
    }

    @Test
    void activeDatabaseExist() {
        Database database = DatabaseService.activeDatabase(owner, realDbName);
        assertNotNull(database);
    }

    @Test
    void activeDatabaseNotExist() {
        assertThrows(
                AccessRestrictedException.class,
                () -> {DatabaseService.activeDatabase(ownerUnreal, realDbName);}
        );
    }

    @Test
    void exists() {
        assertTrue(DatabaseService.exists(realDbName));
    }

    @Test
    void existsNotExist() {
        assertFalse(DatabaseService.exists(unrealDbName));
    }

    @Test
    void byNameExist() {
        assertEquals(realDbName, DatabaseService.byName(realDbName).getName());
    }

    @Test
    void byNameNotExist() {
        assertThrows(NotFoundException.class, () -> {DatabaseService.byName(unrealDbName);});
    }

    @Test
    void forUserExist() {
        assertFalse(DatabaseService.forUser(owner).isEmpty());
    }

    @Test
    void forUserNotExist() {
        assertTrue(DatabaseService.forUser(ownerUnreal).isEmpty());
    }

    @Test
    void size() {
        assertEquals(size, DatabaseService.size(realDbName));
    }

    @Test
    void create() {
        DatabaseService.create(dbNameCreate, owner, owner);
        assertTrue(DatabaseService.exists(dbNameCreate));
    }

    @Test
    void drop() {
        DatabaseService.create(dbNameDrop, owner, owner);
        assertTrue(DatabaseService.exists(dbNameDrop));
        DatabaseService.drop(DatabaseService.byName(dbNameDrop));
        assertFalse(DatabaseService.exists(dbNameDrop));
    }
}
