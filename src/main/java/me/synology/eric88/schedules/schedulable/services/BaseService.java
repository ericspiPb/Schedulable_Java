package me.synology.eric88.schedules.schedulable.services;

import me.synology.eric88.schedules.schedulable.models.BaseLog;
import me.synology.eric88.schedules.schedulable.models.BaseModel;
import me.synology.eric88.schedules.schedulable.models.BaseSchedule;
import me.synology.eric88.schedules.schedulable.repositories.BaseModelRepository;

public abstract class BaseService implements Runnable {
  protected BaseModelRepository<BaseModel> repo;
  protected BaseModelRepository<BaseSchedule> scheduleRepo;
  protected BaseModelRepository<BaseLog> logRepo;
}