package com.sparta.datamigration.util;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import start.Main;

public class LoggingClass {
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void traceLog(String message) {
        logger.trace(message);
    }

    public static void errorLog(String message) {
        logger.error(message);
    }
}
