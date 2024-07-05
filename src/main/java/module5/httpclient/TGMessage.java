package module5.httpclient;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public class TGMessage {
    final String chat_id;
    final String text;
}
