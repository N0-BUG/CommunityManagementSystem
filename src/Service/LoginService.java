package Service;

import Dto.UserDto;

public interface LoginService {
    public UserDto login(String user_name, String user_password, String user_ident);

}
