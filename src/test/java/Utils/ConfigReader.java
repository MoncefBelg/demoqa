package Utils;

import com.fasterxml.jackson.databind.annotation.JsonAppend;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

     public static Properties prop;

    public static Properties readProperty(String filePath){
  try {

    FileInputStream file = new FileInputStream(filePath);
    prop = new Properties();
    prop.load(file);


 } catch (FileNotFoundException e) {
      System.err.println("Property file not found: " + filePath);
      e.getMessage();
} catch (IOException e) {
      System.err.println("Failed to load property file: " + filePath);
      e.getMessage();

  }
return prop;
    }

    public  static String getPropertyValue(String key){

        return prop.getProperty(key);

    }

  }
