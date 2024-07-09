package tgbotg42.types;

import com.google.gson.annotations.SerializedName;

public class InlineButton extends MarkupButton {
    @SerializedName("callback_data")
    private String callbackData;

    public InlineButton(String text) {
        super(text);
    }
}
