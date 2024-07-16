package Members;

public class User {
    private String user_name;
    private String user_password;
    private String user_ident;

    public User(String user_name, String user_password, String user_ident) {
        this.user_name = user_name;
        this.user_password = user_password;
        this.user_ident = user_ident;
    }

    public String getUser_name() {
        return user_name;
    }

    public String getUser_password() {
        return user_password;
    }

    public String getUser_ident() {
        return user_ident;
    }
}
