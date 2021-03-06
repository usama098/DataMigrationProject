package com.sparta.datamigration.util;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.sparta.datamigration.start.Main;

public class LoggingClass {
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void traceLog(String message) {
        logger.trace(message);
    }

    public static void errorLog(String message) {
        logger.error(message);
    }

    public static void infoLog(String message) {
        logger.info(message);
    }

    public static void debugLog(String message) {
        logger.debug(message);
    }

    public static void warnLog(String message){ logger.warn(message);}

    public static void fatalLog(String message){ logger.fatal(message);}
}
