package com.framework.performance.config;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ConfigManagerTest {

    @Test
    void shouldLoadEnvironmentConfiguration() {

        String baseUrl = ConfigManager.get("base.url");

        Assertions.assertNotNull(baseUrl);
    }

    @Test
    void shouldReturnDefaultValue() {

        String value =
                ConfigManager.get("dummy.key","default");

        Assertions.assertEquals("default", value);
    }

}