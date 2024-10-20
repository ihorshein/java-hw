package org.ihorshein.lesson4.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DbConnection {
  public static Connection connectionMysql() {
    try {
      Properties properties = Config.load("/mysql.properties");

      return DriverManager.getConnection(properties.getProperty("url"), properties);
    } catch (SQLException e) {
      throw new RuntimeException("Unable to establish connection to database.", e);
    }
  }
}
