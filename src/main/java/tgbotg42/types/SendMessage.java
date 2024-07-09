package tgbotg42.types;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SendMessage {
    @SerializedName("chat_id")
    private String chatId;
    private String text;
    @SerializedName("reply_markup")
    private ReplyMarkup replyMarkup;

    public SendMessage(String chatId, String text) {
        this.chatId = chatId;
        this.text = text;
    }
}
