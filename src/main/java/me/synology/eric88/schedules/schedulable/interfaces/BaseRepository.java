package me.synology.eric88.schedules.schedulable.interfaces;

import java.util.Collection;

public interface BaseRepository<T> {
  public void fetchFromDatabaseTop(int numOfRecord);

  public void add(T item);

  public void add(Collection<? extends T> items);

  public void update(T item);

  public void remove(T item);
}