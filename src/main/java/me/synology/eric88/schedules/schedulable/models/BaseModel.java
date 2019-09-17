package me.synology.eric88.schedules.schedulable.models;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Base Database Table including createdAt and updatedAt
 */
public abstract class BaseModel {
  protected String tableName;

  protected UUID id;
  protected LocalDateTime createdAt;
  protected LocalDateTime updatedAt;

  public BaseModel() {
    this.tableName = this.getClass().getSimpleName();
  }

  public String getTableName() {
    return tableName;
  }

  public void setTableName(String tableName) {
    this.tableName = tableName;
  }

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public LocalDateTime getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(LocalDateTime createdAt) {
    this.createdAt = createdAt;
  }

  public LocalDateTime getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(LocalDateTime updatedAt) {
    this.updatedAt = updatedAt;
  }
}