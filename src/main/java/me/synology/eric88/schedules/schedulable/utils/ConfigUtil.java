package me.synology.eric88.schedules.schedulable.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import java.util.Properties;

public class ConfigUtil {
  public void createConfigFile(String fileName) throws FileNotFoundException {
    Properties prop = new Properties();
  
    InputStream inputStream = getClass().getResourceAsStream(fileName);
    if (inputStream != null) {
      try {
        prop.load(inputStream);
      } catch (IOException e) {
        e.printStackTrace();
      }
    } else {
      throw new FileNotFoundException("property file '" + fileName + "' not found in the classpath");
    }
  }
}