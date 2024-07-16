package Members;

public class Notice {
    private String notice_info;
    private String notice_publisher;
    private String notice_date;
    private int notice_index;

    public Notice(int notice_index, String notice_info, String notice_publisher, String notice_date) {
        this.notice_info = notice_info;
        this.notice_publisher = notice_publisher;
        this.notice_date = notice_date;
        this.notice_index = notice_index;
    }

    public Notice(String notice_info, String notice_publisher, String notice_date) {
        this.notice_info = notice_info;
        this.notice_publisher = notice_publisher;
        this.notice_date = notice_date;
    }

    public String getNotice_info() {
        return notice_info;
    }

    public String getNotice_publisher() {
        return notice_publisher;
    }

    public String getNotice_date() {
        return notice_date;
    }

    public int getNotice_index() {
        return notice_index;
    }
}
