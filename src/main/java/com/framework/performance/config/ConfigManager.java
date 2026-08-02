package com.framework.performance.config;

import java.io.InputStream;
import java.io.IOException;
import java.util.Properties;

public final class ConfigManager {

    private static final Properties PROPERTIES = new Properties();

    private static final String FRAMEWORK_CONFIG = "framework.properties";

    private ConfigManager() {}

    static {
        loadConfigurations();
    }

    private static void loadConfigurations() {

        loadFrameworkProperties();

        String environment =
                System.getProperty(
                        "environment",
                        PROPERTIES.getProperty("default.environment"));

        loadEnvironmentProperties(environment);
    }

    private static void loadFrameworkProperties() {

        loadProperties(FRAMEWORK_CONFIG);
    }

    private static void loadEnvironmentProperties(String environment) {

        loadProperties("environments/" + environment + ".properties");
    }

    private static void loadProperties(String fileName) {

        try (InputStream inputStream =
                     ConfigManager.class
                             .getClassLoader()
                             .getResourceAsStream(fileName)) {

            if (inputStream == null) {

                throw new RuntimeException(
                        "Unable to find configuration file : " + fileName);
            }

            PROPERTIES.load(inputStream);

        } catch (IOException e) {

            throw new RuntimeException(
                    "Unable to load configuration file : " + fileName, e);
        }
    }

    public static String get(String key) {

        return PROPERTIES.getProperty(key);
    }

    public static String get(String key, String defaultValue) {

        return PROPERTIES.getProperty(key, defaultValue);
    }

}