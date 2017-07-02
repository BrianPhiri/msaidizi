package blvck.chausiku.nick.msaidizi.models;

import java.util.Date;

/**
 * Created by brianphiri on 7/2/17.
 */

public class Message {
    private String text;
    private String sender;
    private Date date;

    public Message() {
    }

    public Message(String text, String sender, Date date) {
        this.text = text;
        this.sender = sender;
        this.date = date;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
