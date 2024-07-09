package tgbotg42.exception;

public class TelegramException extends Exception {
    public TelegramException(String message) {
        super(message);
    }
    public TelegramException( Throwable cause) {
        super(cause);
    }
}
