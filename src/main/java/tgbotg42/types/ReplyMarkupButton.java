package tgbotg42.types;

import com.google.gson.annotations.SerializedName;
import lombok.Setter;

@Setter
public class ReplyMarkupButton extends MarkupButton {
    @SerializedName("request_contact")
    private boolean requestContact;

    @SerializedName("request_location")
    private boolean requestLocation;

    public ReplyMarkupButton(String text) {
        super(text);
    }
}
