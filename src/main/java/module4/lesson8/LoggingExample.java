package module4.lesson8;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.XMLFormatter;

public class LoggingExample {
    public static Logger logger = Logger.getLogger(LoggingExample.class.getName());

    public static void main(String[] args) throws IOException {
        logger.setUseParentHandlers(false);
        XMLFormatter xmlFormatter = new XMLFormatter();

        FileHandler handler = new FileHandler("");
        handler.setFormatter(xmlFormatter);

        logger.addHandler(handler);
        logger.info( "Hello Tashkent");
        logger.log(Level.INFO, "Hello Tashkent");
    }
}
