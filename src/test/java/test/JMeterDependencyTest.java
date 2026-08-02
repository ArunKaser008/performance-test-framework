package test;

import org.apache.jmeter.util.JMeterUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class JMeterDependencyTest {

    @Test
    void shouldLoadJMeterClasses() {

        Assertions.assertNotNull(JMeterUtils.class);

    }
}