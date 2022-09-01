package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesManagement {

    private static Properties prop;

    static {
        try (InputStream input = new FileInputStream("src/main/resources/config.properties")) {
            prop = new Properties();
            if (input != null) {
                prop.load(input);

            } else {
                throw new FileNotFoundException();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    public String getKey(String key) throws IOException {

        try {
            String val = prop.getProperty(key);
            if (val == null) {
                throw new IOException();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop.getProperty(key);
    }
}