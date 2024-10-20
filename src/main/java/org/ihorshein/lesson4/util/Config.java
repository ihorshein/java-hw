package org.ihorshein.lesson4.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {
  public static Properties load(String configName) {
    try (InputStream input = Config.class.getResourceAsStream(configName)) {
      if (input == null) {
        throw new RuntimeException("The specified resource file could not be found.");
      }

      Properties config = new Properties();
      config.load(input);

      return config;
    } catch (IOException e) {
      throw new RuntimeException("An error occurred while reading the configuration.", e);
    }
  }
}
