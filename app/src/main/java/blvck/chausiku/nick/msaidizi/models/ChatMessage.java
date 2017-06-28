package blvck.chausiku.nick.msaidizi.models;

/**
 * Created by brianphiri on 6/28/17.
 */

public class ChatMessage {
    String name, Message;

    public ChatMessage() {
    }

    public ChatMessage(String name, String message) {
        this.name = name;
        Message = message;
    }

    public String getName() {
        return name;
    }

    public String getMessage() {
        return Message;
    }
}
