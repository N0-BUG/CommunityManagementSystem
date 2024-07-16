package Dto;

import Members.User;

public class UserDto {
    private Integer message;
    private User user;

    public Integer getMessage() {
        return message;
    }

    public User getUser() {
        return user;
    }

    public void setMessage(Integer message) {
        this.message = message;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
