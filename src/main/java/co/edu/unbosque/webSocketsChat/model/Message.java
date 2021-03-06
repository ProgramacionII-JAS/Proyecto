package co.edu.unbosque.webSocketsChat.model;

/**
 * @author Oscar Santiago Florez, Yilber Andrey Rojas, Ana Lucero Perez y Juan Sebastian vargas
 */
public class Message {

    private String from;
    private String to;
    private String content;
    private String messageCode;


    public String getMessageCode() {
        return messageCode;
    }

    public void setMessageCode(String messageCode) {
        this.messageCode = messageCode;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}