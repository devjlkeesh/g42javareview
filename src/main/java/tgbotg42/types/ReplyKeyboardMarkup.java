package tgbotg42.types;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReplyKeyboardMarkup extends ReplyMarkup {
    protected final MarkupButton[][] keyboard;

    @SerializedName("resize_keyboard")
    private boolean resizeKeyboard;

    public ReplyKeyboardMarkup(MarkupButton[][] keyboard) {
        this.keyboard = keyboard;
    }

}
