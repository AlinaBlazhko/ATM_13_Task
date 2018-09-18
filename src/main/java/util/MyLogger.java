package util;

import org.apache.log4j.FileAppender;
import org.apache.log4j.Logger;
import java.util.Date;

import java.text.SimpleDateFormat;

public class MyLogger {
    static{
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        System.setProperty("current.date.time", dateFormat.format(new Date()));
    }

    final static Logger log = Logger.getLogger(MyLogger.class);

    public static void error(String message) {
        log.error(message);
    }

    public static void error(String message, Throwable throwable) {
        log.error(message, throwable);
    }

    public static void info(String message) {
        log.info(message);
    }

    public static void debug(String message) {
        log.debug(message);
    }

    public static void warn(String message) {
        log.warn(message);
    }

    public static void trace(String message) {
        log.trace(message);
    }

    public static void log(String message){
        log.info(message);
    }

}
