package module5.httpclient;

import com.google.gson.Gson;
import module5.g42logging.Secrets;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpClientExample {
    public static void main(String[] args) throws IOException, InterruptedException {
        Gson gson = new Gson();
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create("https://jsonplaceholder.typicode.com/posts/" + 1))
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        Post post = gson.fromJson(response.body(), Post.class);
        System.out.println(response);
        System.out.println(post);
        TGMessage message = new TGMessage(Secrets.chatId, "hello  darkness my old friend");
        HttpRequest sendMessageRequest = HttpRequest.newBuilder()
                .uri(URI.create(Secrets.sendMessage))
                .header("Content-Type", "application/json")
                .method("POST", HttpRequest.BodyPublishers.ofString(gson.toJson(message)))
                .build();
        HttpResponse<String> telegramResponse = httpClient.send(sendMessageRequest, HttpResponse.BodyHandlers.ofString());
        System.out.println("telegramResponse.body() = " + telegramResponse.body());
    }
}
