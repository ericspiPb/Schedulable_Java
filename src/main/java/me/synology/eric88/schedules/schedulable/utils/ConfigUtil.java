package me.synology.eric88.schedules.schedulable.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigUtil {
  private Properties properties;

  public ConfigUtil() {
    this("config.properties");
  }

  public ConfigUtil(String configFileName) {
    try {
      properties = new Properties();
      InputStream configInputStream = this.getClass().getClassLoader().getResourceAsStream(configFileName);
      properties.load(configInputStream);
      configInputStream.close();
    } catch (NullPointerException nf) {
      FileLogUtil log = new FileLogUtil();
      log.addErrorLog(configFileName + " does not exist");
    } catch (IOException io) {
      FileLogUtil log = new FileLogUtil();
      log.addErrorLog(io.getMessage());
    }
  }

  public String getConfig(String key) {
    return this.properties.getProperty(key);
  }

  public String getConfig(String key, String defaultValue) {
    return this.properties.getProperty(key, defaultValue);
  }
}