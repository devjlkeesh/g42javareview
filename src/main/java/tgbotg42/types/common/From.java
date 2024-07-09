package tgbotg42.types.common;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class From{
	private long id;
	@SerializedName("is_bot")
	private boolean isBot;
	@SerializedName("first_name")
	private String firstName;
	private String username;
}