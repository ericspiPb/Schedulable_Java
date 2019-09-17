package me.synology.eric88.schedules.schedulable.models;

import java.time.LocalDate;

public abstract class BaseSchedule extends BaseModel {
  protected String status;
  protected LocalDate scheduledAt;

  public BaseSchedule(String status, LocalDate scheduledAt) {
    this.setStatus(status);
    this.setScheduledAt(scheduledAt);
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public LocalDate getScheduledAt() {
    return scheduledAt;
  }

  public void setScheduledAt(LocalDate scheduledAt) {
    this.scheduledAt = scheduledAt;
  }
}