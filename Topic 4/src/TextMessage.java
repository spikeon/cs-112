public class TextMessage extends Message {
    public TextMessage(String message) {
        super(message);
    }

    public String getMessage() {
        return super.getMessage().substring(0, 140);
    }
}
