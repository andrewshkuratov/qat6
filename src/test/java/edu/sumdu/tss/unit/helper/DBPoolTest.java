package edu.sumdu.tss.unit.helper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.File;

import edu.sumdu.tss.elephant.helper.DBPool;
import edu.sumdu.tss.elephant.helper.Keys;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class DBPoolTest {
    private static final String databaseName = "elephant";
    private static final String url = "postgresql://%s:%s@%s:%s/%s";

    @BeforeAll
    static void setUp() {
        Keys.loadParams(new File("config.properties"));
    }

    @Test
    public void getConnection() {
        assertNotNull(DBPool.getConnection());
        assertNotNull(DBPool.getConnection(databaseName));
    }

    @Test
    public void dbUtilUrl() {
        String result = String.format(url, Keys.get("DB.USERNAME"), Keys.get("DB.PASSWORD"), Keys.get("DB.URL"), Keys.get("DB.PORT"), databaseName);
        assertEquals(result, DBPool.dbUtilUrl(databaseName));
    }
}
