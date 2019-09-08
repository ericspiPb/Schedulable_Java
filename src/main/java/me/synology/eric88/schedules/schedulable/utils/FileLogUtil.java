package me.synology.eric88.schedules.schedulable.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.SecurityException;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * File Utils is designed for error log and debug log with simple java built in functions
 */
public class FileLogUtil {
  private String debugFolder;
  private String errorFolder;
  private String filename;

  /**
   * Using ISO_LOCAL_DATE for filename for appending log messages example of
   * ISO_LOCAL_DATE is '2019-09-09.log'
   */
  public FileLogUtil() {
    this("./logs/debug", "./logs/error", DateTimeFormatter.ISO_LOCAL_DATE.format(LocalDate.now()) + ".log");
  }

  /**
   * Using specified folder and filename logging message
   * 
   * @param filename path/to/filename logging message
   */
  public FileLogUtil(String filename) {
    this("./logs/debug", "./logs/error", filename);
  }

  /**
   * Using specified folder and filename logging message
   * 
   * @param folder debug and error folder name
   * @param filename path/to/filename logging message
   */
  public FileLogUtil(String folder, String filename) {
    this(folder, folder, filename);
  }

  /**
   * Using difference debug, error folder and filename for logging message
   * 
   * @param debugFolder path/to/debug folder name
   * @param errorFolder path/to/error folder name
   * @param filename filename logging message
   */
  public FileLogUtil(String debugFolder, String errorFolder, String filename) {
    this.setDebugFolder(debugFolder);
    this.setErrorFolder(errorFolder);
    this.setFilename(filename);
  }

  /**
   * Write messge to log file with specified format 
   * LocalDateTime log message\n
   * @param folder path/to/ i.e. "C:/path/to/folder" or "./folder" it will make directories if does not exists
   * @param filename filename in folder normally yyyy-MM-dd.log
   * @param message the message to append
   * @throws SecurityException thrown if does not have permission to write file
   * @throws IOException thrown if other error
   */
  private void writeLog(String folder, String filename, String message) throws SecurityException, IOException {
    // Create folders
    File folders = new File(folder);
    folders.mkdirs();

    // Create log file
    File log = new File(folders + "/" + this.getFilename());

    // append header message in format yyyy-MM-ddTHH:mm:ss.
    DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
    String timeAt = formatter.format(LocalDateTime.now());
    FileWriter logWriter = new FileWriter(log, true);
    logWriter.append(timeAt + " " + message + "\n");
    logWriter.flush();
    logWriter.close();
  }

  /**
   * Add message to debug logs folder with the specified filename
   * @param message the log message to add
   * @return
   */
  public FileLogUtil addDebugLog(String message) {
    try {
      this.writeLog(this.getDebugFolder(), this.getFilename(), message);
    } catch (SecurityException se) {
      se.printStackTrace();
    } catch (IOException io) {
      io.printStackTrace();
    }

    return this;
  }

  /**
   * Add message to error logs folder with the specified filename
   * @param message the log message to add
   * @return
   */
  public FileLogUtil addErrorLog(String message) {
    try {
      this.writeLog(this.getErrorFolder(), this.getFilename(), message);
    } catch (SecurityException se) {
      se.printStackTrace();
    } catch (IOException io) {
      io.printStackTrace();
    }

    return this;
  }

  public String getDebugFolder() {
    return debugFolder;
  }

  public void setDebugFolder(String debugFolder) {
    this.debugFolder = debugFolder;
  }

  public String getErrorFolder() {
    return errorFolder;
  }

  public void setErrorFolder(String errorFolder) {
    this.errorFolder = errorFolder;
  }

  public String getFilename() {
    return filename;
  }

  public void setFilename(String filename) {
    this.filename = filename;
  }
}