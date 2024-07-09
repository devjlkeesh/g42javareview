package tgbotg42.types.common;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class Result{
	private int date;
	private Chat chat;
	@SerializedName("message_id")
	private int messageId;
	private From from;
	private String text;
}