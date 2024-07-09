package tgbotg42;

import com.google.gson.Gson;
import module5.g42logging.Secrets;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tgbotg42.exception.TelegramException;
import tgbotg42.types.ReplyKeyboardMarkup;
import tgbotg42.types.ReplyMarkup;
import tgbotg42.types.ReplyMarkupButton;
import tgbotg42.types.SendMessage;
import tgbotg42.types.common.Message;

import static org.assertj.core.api.Assertions.assertThat;

class TelegramBotTest {

    TelegramBot bot;

    @BeforeEach
    void setUp() {
        bot = new TelegramBot("6954878031:AAF5K05hqUQ451gAdoYSdGzRRpTJbIkRF10");
    }

    @Test
    void simpleSendMessageTest() throws TelegramException {
        Message message = bot.sendMessage(new SendMessage(Secrets.chatId, "Hello from junit 5 jupiter"));
        System.out.println(message);
        assertThat(message).isNotNull();
        assertThat(message.isOk()).isTrue();
    }

    @Test
    void simpleSendMessageWithReplyMarkUpTest() throws TelegramException {
        ReplyMarkupButton contact = new ReplyMarkupButton("contact");
        contact.setRequestContact(true);

        ReplyMarkupButton location = new ReplyMarkupButton("location");
        location.setRequestLocation(true);

        ReplyMarkupButton text = new ReplyMarkupButton("just text");

        ReplyMarkupButton[][] buttons = {
                {
                        contact, location
                },
                {
                        text
                },
        };
        ReplyKeyboardMarkup replyMarkup = new ReplyKeyboardMarkup(buttons);
        replyMarkup.setResizeKeyboard(true);
        SendMessage sendMessage = new SendMessage(
                Secrets.chatId,
                "Hello from junit ",
                replyMarkup
        );
        System.out.println(new Gson().toJson(sendMessage));
        Message message = bot.sendMessage(sendMessage);
        System.out.println(message);
        assertThat(message).isNotNull();
        assertThat(message.isOk()).isTrue();
    }
}