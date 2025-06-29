package Utils;

import com.fasterxml.jackson.databind.annotation.JsonAppend;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

     static Properties prop;

    public static Properties readProperty(String filePath){
  try {

    FileInputStream file = new FileInputStream(filePath);
    prop = new Properties();
    prop.load(file);


 } catch (FileNotFoundException e) {
    e.getMessage();
} catch (IOException e) {
      e.getMessage();

  }
return prop;
    }

    public  static String getPropertyValue(String key){
        if (prop == null) {
            readProperty("src/test/resources/config.properties");
        }
        return prop.getProperty(key);

    }

  }
