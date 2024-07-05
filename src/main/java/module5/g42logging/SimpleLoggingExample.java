package module5.g42logging;

import module5.g42logging.b.B;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

public class SimpleLoggingExample {
    static {
        String file = SimpleLoggingExample.class.getClassLoader()
                .getResource("logging.properties").getFile();
        System.setProperty("java.util.logging.config.file", file);
    }

    private static final Logger logger = Logger.getLogger("MyLogger");

    public static void main(String[] args) throws IOException {
        LogRecord logRecord = new LogRecord(Level.INFO, "Hello this is simple warning log");
        logger.log(logRecord);
        logger.warning("this log for file and consol");
        logger.log(Level.SEVERE,"This log for telegram alert",new RuntimeException());
        try {
            new B().m();
        } catch (Exception e) {
            logger.log(Level.SEVERE, e.getMessage(), e);
        }
    }
}
