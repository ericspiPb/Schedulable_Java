package me.synology.eric88.schedules.schedulable.utils;

import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class ConfigUtilTest {
  @Test public void testDebugErrorLog() {
    ConfigUtil config = new ConfigUtil();
    ConfigUtil config2 = new ConfigUtil("config2.properties");

    assertTrue(config.getConfig("key").equals("value"));
    assertTrue(config2.getConfig("key", null) == null);
    assertTrue(config2.getConfig("key", "abc").equals("abc"));
  }
}