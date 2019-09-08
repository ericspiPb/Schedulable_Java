package me.synology.eric88.schedules.schedulable.interfaces;

public interface Schedulable {
  public String getScheduleTableName();
  public String getLogTableName();

  public Schedulable addSchedule(String sql, String log);
  public Boolean removeSchedule(String uuid);
}