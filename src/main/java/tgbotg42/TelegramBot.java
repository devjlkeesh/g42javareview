package tgbotg42;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import tgbotg42.exception.TelegramException;
import tgbotg42.types.SendMessage;
import tgbotg42.types.common.Message;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class TelegramBot {
    private final String token;
    private final HttpClient httpClient;
    private final String url;
    private final Gson gson;

    public TelegramBot(String token) {
        this.token = token;
        this.httpClient = HttpClient.newHttpClient();
        this.url = "https://api.telegram.org/bot" + token;
        this.gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
    }


    public Message sendMessage(SendMessage message) throws TelegramException {
        try {
            HttpRequest sendMessageRequest = HttpRequest.newBuilder()
                    .uri(URI.create(url + "/sendMessage"))
                    .header("Content-Type", "application/json")
                    .method("POST", HttpRequest.BodyPublishers.ofString(gson.toJson(message)))
                    .build();
            HttpResponse<String> response = httpClient.send(sendMessageRequest, HttpResponse.BodyHandlers.ofString());
            JsonObject jsonObject = gson.fromJson(response.body(), JsonObject.class);
            if (!jsonObject.get("ok").getAsBoolean()) {
                throw new TelegramException(jsonObject.get("description").getAsString());
            }
            return gson.fromJson(jsonObject, Message.class);
        } catch (IOException | InterruptedException e) {
            throw new TelegramException(e);
        }
    }

}
