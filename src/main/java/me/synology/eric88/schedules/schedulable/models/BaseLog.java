package me.synology.eric88.schedules.schedulable.models;

/**
 * Base Log Table including createdAt and updatedAt
 */
public abstract class BaseLog extends BaseModel {
  protected String action;

  public String getAction() {
    return action;
  }

  public void setAction(String action) {
    this.action = action;
  }
}