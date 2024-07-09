package tgbotg42.types.common;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class Chat{
	private long id;
	private String type;
	@SerializedName("first_name")
	private String firstName;
}