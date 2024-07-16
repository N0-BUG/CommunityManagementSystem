package Service.conduct;

import Dao.UserDao;
import Dao.conduct.UserDaoConduct;
import Dto.UserDto;
import Members.User;
import Service.LoginService;

public class LoginServiceConduct implements LoginService {
    //注入User访问对象
    private UserDao userDao = new UserDaoConduct();

    @Override
    public UserDto login(String user_name, String user_password, String user_ident) {
        User user = this.userDao.select(user_name);
        UserDto userDto = new UserDto();
        //判断登录信息是否正确
        if (user == null) {
            userDto.setMessage(0);//用户不存在
        } else {
            if (!user.getUser_password().equals(user_password)) {
                userDto.setMessage(-1);//用户名或密码错误
            } else {
                if (user.getUser_ident().equals(user_ident)) {
                    if (user_ident.equals("resident")) {
                        userDto.setMessage(1);//居民登录成功
                        userDto.setUser(user);
                    } else {
                        userDto.setMessage(2);//管理员登录成功
                        userDto.setUser(user);
                    }
                } else {
                    userDto.setMessage(-2);//身份信息不匹配
                }
            }
        }
        return userDto;
    }

}
