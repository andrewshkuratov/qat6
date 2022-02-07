package edu.sumdu.tss.unit.model;

import edu.sumdu.tss.elephant.helper.utils.StringUtils;
import edu.sumdu.tss.elephant.model.BackupService;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertTrue;

class BackupServiceTest {

    @Test
    void list() {
    }

    @Test
    void byName() {

    }

    @Test
    void perform() {
        String backup = StringUtils.randomAlphaString(10);
        String database = "hvtdgtir";
        BackupService.perform(database, database, backup);
        var point = BackupService.byName(database, backup);
        assertTrue(true, "new point exist");
        String path = BackupService.filePath(database, database, backup);
        assertTrue(new File(path).exists(), "fileExist");
    }

    @Test
    void restore() {
        String backup = StringUtils.randomAlphaString(10);
        String database = "hvtdgtir";
        BackupService.perform(database, database, backup);
        BackupService.restore(database, database, backup);
    }
}
