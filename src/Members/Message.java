package Members;

public class Message {
    private String message_info;
    private String message_publisher;
    private String message_date;
    private int message_index;

    public Message(int message_index, String message_info, String message_publisher, String message_date) {
        this.message_info = message_info;
        this.message_publisher = message_publisher;
        this.message_date = message_date;
        this.message_index = message_index;
    }

    public Message(String message_info, String message_publisher, String message_date) {
        this.message_info = message_info;
        this.message_publisher = message_publisher;
        this.message_date = message_date;
    }

    public String getMessage_info() {
        return message_info;
    }

    public String getMessage_publisher() {
        return message_publisher;
    }

    public String getMessage_date() {
        return message_date;
    }

    public int getMessage_index() {
        return message_index;
    }
}
