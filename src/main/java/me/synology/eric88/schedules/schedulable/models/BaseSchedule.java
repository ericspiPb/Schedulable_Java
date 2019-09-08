package me.synology.eric88.schedules.schedulable.models;

import java.time.LocalDateTime;
import java.util.UUID;

import me.synology.eric88.schedules.schedulable.interfaces.Schedulable;

public class BaseSchedule implements Schedulable {
  private String tableName;
  private String scheduleTableName;
  private String logTableName;

  private UUID tableId;
  private LocalDateTime createAt;
  private LocalDateTime updateAt;

  public BaseSchedule(Schedulable schedulable) {
    this.tableName = schedulable.getClass().getSimpleName();
    this.scheduleTableName = schedulable.getClass().getSimpleName() + "_schedules";
    this.logTableName = schedulable.getClass().getSimpleName() + "_logs";
  }

  @Override
  public Schedulable addSchedule(String sql, String log) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Boolean removeSchedule(String uuid) {
    // TODO Auto-generated method stub
    return null;
  }

  public String getTableName() {
    return this.tableName;
  }

  @Override
  public String getScheduleTableName() {
    return scheduleTableName;
  }

  @Override
  public String getLogTableName() {
    return logTableName;
  }
}