package Dao.conduct;

import ConnectionTools.JDBCUtil;
import Dao.UserDao;
import Members.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoConduct implements UserDao {
    //查询user表
    @Override
    public User select(String user_name) {
        //获取连接
        Connection connection = JDBCUtil.getConnection();
        String sql = "select * from user where user_name='" + user_name + "'";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            //将查到的数据传入User对象
            if (resultSet.next()) {
                String name = resultSet.getString("user_name");
                String password = resultSet.getString("user_password");
                String ident = resultSet.getString("user_ident");
                return new User(name, password, ident);

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtil.close(connection, preparedStatement, resultSet);
        }
        return null;
    }

}


