package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static final Properties props = new Properties();

    static {
        try {
            FileInputStream input = new FileInputStream("src/test/resources/env.properties");
            props.load(input);
        } catch (IOException e) {
            throw new RuntimeException("Не удалось загрузить файл env.properties", e);
        }
    }

    public static String get(String key) {
        return props.getProperty(key);
    }
}