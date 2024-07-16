package Members;

public class Manager {
    private String manager_name;
    private String manager_phone;
    private String manager_post;
    private String manager_gender;
    private int manager_index;
    public Manager(String manager_name, String manager_phone, String manager_post, String manager_gender, int manager_index) {
        this.manager_name = manager_name;
        this.manager_phone = manager_phone;
        this.manager_post = manager_post;
        this.manager_gender = manager_gender;
        this.manager_index = manager_index;
    }

    public String getManager_name() {
        return manager_name;
    }

    public String getManager_phone() {
        return manager_phone;
    }

    public String getManager_post() {
        return manager_post;
    }

    public int getManager_index() {
        return manager_index;
    }

    public String getManager_gender() {
        return manager_gender;
    }
}
