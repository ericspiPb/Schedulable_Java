package me.synology.eric88.schedules.schedulable.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.NullPointerException;
import java.lang.SecurityException;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * File Utils is designed for error log and debug log with simple java built in functions
 */
public class FileLogUtil {
  public static final String DEBUG = "DEBUG";
  public static final String ERROR = "ERROR";

  private String debugFolderName;
  private String errorFolderName;
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
   * @param debugFolderName path/to/debug folder name
   * @param errorFolderName path/to/error folder name
   * @param filename filename logging message
   */
  public FileLogUtil(String debugFolderName, String errorFolderName, String filename) {
    this.setDebugFolderName(debugFolderName);
    this.setErrorFolderName(errorFolderName);
    this.setFilename(filename);
  }

  /**
   * Write messge to log file with specified format 
   * LocalDateTime log message\n
   * @param foldername path/to/ i.e. "C:/path/to/folder" or "./folder" it will make directories if does not exists
   * @param filename filename in folder normally yyyy-MM-dd.log
   * @param message the message to append
   * @throws SecurityException thrown if does not have permission to write file
   * @throws IOException thrown if other error
   */
  private void writeLog(String foldername, String filename, String message) throws SecurityException, IOException {
    File log = this.getFolderFileCreateIfNeeded(foldername, filename);

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
      this.writeLog(this.getDebugFolderName(), this.getFilename(), message);
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
      this.writeLog(this.getErrorFolderName(), this.getFilename(), message);
    } catch (SecurityException se) {
      se.printStackTrace();
    } catch (IOException io) {
      io.printStackTrace();
    }

    return this;
  }

  /**
   * Get the java.io.File for other purpose
   * FIXME: e.printStackTrace() with file does not work with this function propertly
   * 
   * @param logLevel DEBUG or ERROR in the static value of class is provided
   * @return File file under predefined log level
   * @throws FileNotFoundException thrown if the logLevel param is not defined
   */
  public File getLogFile(String logLevel) throws FileNotFoundException {
    String folder = ".";
    switch(logLevel) {
      case FileLogUtil.DEBUG:
        folder = this.getDebugFolderName();
        break;
      case FileLogUtil.ERROR:
        folder = this.getErrorFolderName();
        break;
      default:
        throw new FileNotFoundException("log level is invalid");
    }

    return this.getFolderFileCreateIfNeeded(folder, this.getFilename());
  }

  /**
   * Get specify file in the folder path. Both folder and filename will be created if does not exists
   * 
   * @param foldername path/to/
   * @param filename filename with extension
   * @return File
   */
  public File getFolderFileCreateIfNeeded(String foldername, String filename) {
    // Create folders
    File folder = new File(foldername);
    folder.mkdirs();

    // Create log file
    File log = new File(folder + "/" + this.getFilename());

    return log;
  }

  public String getDebugFolderName() {
    return debugFolderName;
  }

  public void setDebugFolderName(String debugFolderName) {
    this.debugFolderName = debugFolderName;
  }

  public String getErrorFolderName() {
    return errorFolderName;
  }

  public void setErrorFolderName(String errorFolderName) {
    this.errorFolderName = errorFolderName;
  }

  public String getFilename() {
    return filename;
  }

  public void setFilename(String filename) {
    this.filename = filename;
  }
}