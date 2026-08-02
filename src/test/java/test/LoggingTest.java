package test;

import com.framework.performance.utils.LoggerUtil;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

public class LoggingTest {

    private static final Logger logger =
            LoggerUtil.getLogger(LoggingTest.class);

    @Test
    void shouldWriteLogs() {

        logger.info("Framework logging initialized.");

        logger.warn("Sample warning message.");

        logger.error("Sample error message.");

    }
}