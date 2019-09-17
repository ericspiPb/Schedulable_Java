package me.synology.eric88.schedules.schedulable.repositories;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.mariadb.jdbc.MariaDbPoolDataSource;

import me.synology.eric88.schedules.schedulable.interfaces.BaseRepository;
import me.synology.eric88.schedules.schedulable.models.BaseModel;
import me.synology.eric88.utilities.DatabaseUtil;
import me.synology.eric88.utilities.LogUtil;

public abstract class BaseModelRepository<T extends BaseModel> implements BaseRepository<T> {
  protected T type;
  protected List<T> models;

  protected MariaDbPoolDataSource db;
  protected LogUtil log;

  public BaseModelRepository() {
    this.models = new ArrayList<T>();

    this.db = DatabaseUtil.getInstance().getPool(3);
    this.log = new LogUtil();
  }

  @Override
  public void fetchFromDatabaseTop(int numOfRecord) {
    Connection conn = null;
    try {
      conn = this.db.getConnection();
      String sql = "SELECT * FROM " + type.getTableName() + " LIMIT " + numOfRecord;
      System.out.println(sql);
    } catch (SQLException sqle) {
      this.log.addErrorLog(sqle);
    } finally {
      try {
        if (conn != null) {
          conn.close();
        }
      } catch(SQLException sqle) {
        this.log.addErrorLog(sqle);
      }
    }
  }
}