package module5.g42logging;

import java.util.logging.Filter;
import java.util.logging.Level;
import java.util.logging.LogRecord;

public class TelegramAlertFilter implements Filter {
    @Override
    public boolean isLoggable(LogRecord record) {
        return Level.SEVERE.equals(record.getLevel());
    }
}
