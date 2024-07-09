package tgbotg42.types;

import com.google.gson.annotations.SerializedName;

public class InlineKeyboardMarkup extends ReplyMarkup {
    @SerializedName("inline_keyboard")
    private final MarkupButton[][] inlineMarkupButton;

    public InlineKeyboardMarkup(MarkupButton[][] inlineMarkupButton) {
        this.inlineMarkupButton = inlineMarkupButton;
    }
}
