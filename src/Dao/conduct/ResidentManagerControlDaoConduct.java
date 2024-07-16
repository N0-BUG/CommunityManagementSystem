package Dao.conduct;

import ConnectionTools.JDBCUtil;
import Dao.ResidentManagerControlDao;
import Members.Manager;
import Members.Resident;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ResidentManagerControlDaoConduct implements ResidentManagerControlDao {
    @Override
    public List<Manager> list() {
        //获取连接
        Connection connection = JDBCUtil.getConnection();
        String sql = "select * from manager";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        //定义管理员信息集合
        List<Manager> list = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            //将查到的数据传入Resident对象
            while (resultSet.next()) {
                int id = resultSet.getInt("manager_index");
                String name = resultSet.getString("manager_name");
                String phone = resultSet.getString("manager_phone");
                String gender = resultSet.getString("manager_gender");
                String post = resultSet.getString("manager_post");
                //传入参数
                list.add(new Manager(name, phone, post, gender,id));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtil.close(connection, preparedStatement, resultSet);
        }
        return list;
    }

    //管理员一览搜索功能
    @Override
    public List<Manager> search(String key, String value) {
        //获取连接
        Connection connection = JDBCUtil.getConnection();
        String sql = "select * from manager where " + key + " like '%" + value + "%'";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        //定义管理员信息集合
        List<Manager> list = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("manager_index");
                String name = resultSet.getString("manager_name");
                String phone = resultSet.getString("manager_phone");
                String gender = resultSet.getString("manager_gender");
                String post = resultSet.getString("manager_post");
                //传入参数
                list.add(new Manager(name, phone, post, gender,id));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtil.close(connection, preparedStatement, resultSet);
        }
        return list;
    }

}
