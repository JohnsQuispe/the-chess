package br.com.johnsquispe.thechess.domain.logger;

import org.slf4j.LoggerFactory;

public class ApplicationLogger {

    public static void error (String message, Class clazz, Throwable throwable) {
        LoggerFactory.getLogger(clazz).error(message, throwable);
    }

    public static void info (String message, Class clazz) {
        LoggerFactory.getLogger(clazz).info(message);
    }

    public static void warn (String message, Class clazz) {
        LoggerFactory.getLogger(clazz).warn(message);
    }


}
