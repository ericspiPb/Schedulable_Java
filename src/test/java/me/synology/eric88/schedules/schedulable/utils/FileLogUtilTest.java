package me.synology.eric88.schedules.schedulable.utils;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.Test;

public class FileLogUtilTest {
  @Test public void testDebugErrorLog() {
    FileLogUtil log = new FileLogUtil();
    log.addDebugLog("Testing existing");
    log.addErrorLog("Testing existing");

    File checkDebugFile = new File("./logs/debug/" + DateTimeFormatter.ISO_LOCAL_DATE.format(LocalDate.now()) + ".log");
    File checkErrorFile = new File("./logs/debug/" + DateTimeFormatter.ISO_LOCAL_DATE.format(LocalDate.now()) + ".log");
    assertTrue(checkDebugFile.exists() && checkErrorFile.exists());
  }
}
