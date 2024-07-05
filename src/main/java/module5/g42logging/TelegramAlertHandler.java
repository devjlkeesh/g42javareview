package module5.g42logging;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.logging.LogRecord;
import java.util.logging.StreamHandler;

public class TelegramAlertHandler extends StreamHandler {
    public TelegramAlertHandler() {
//        super.setFormatter(new TelegramAlertFormatter());
//        super.setFilter(new TelegramAlertFilter());
    }

    @Override
    public synchronized void publish(LogRecord record) {
        if (isLoggable(record)) {
            try {
                String formattedMEssage = getFormatter().format(record);
                String bodyMessage = """
                        {
                            "chat_id":"%s",
                            "text":"%s"
                        }""".formatted(Secrets.chatId, formattedMEssage);

                HttpClient httpClient = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .POST(HttpRequest.BodyPublishers.ofString(bodyMessage))
                        .uri(URI.create(Secrets.sendMessage))
                        .header("Content-Type", "application/json")
                        .build();
                httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public boolean isLoggable(LogRecord record) {
        return getFilter().isLoggable(record);
    }

}
