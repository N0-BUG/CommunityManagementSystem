package Dao.conduct;

import ConnectionTools.JDBCUtil;
import Dao.ManagerControlDao;
import Members.Resident;
import Members.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//社区人员管理全局查询展示
public class ManagerControlDaoConduct implements ManagerControlDao {
    @Override
    public List<Resident> list() {
        //获取连接
        Connection connection = JDBCUtil.getConnection();
        String sql = "select * from resident";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        //定义居民信息集合
        List<Resident> list = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            //将查到的数据传入Resident对象
            while (resultSet.next()) {
                int id = resultSet.getInt("resident_index");
                String name = resultSet.getString("resident_name");
                String phone = resultSet.getString("resident_phone");
                String houseNumber = resultSet.getString("resident_houseNumber");
                String gender = resultSet.getString("resident_gender");
                //传入参数
                list.add(new Resident(id, name, phone, houseNumber, gender));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtil.close(connection, preparedStatement, resultSet);
        }
        return list;
    }

    //社区人员管理搜索功能
    @Override
    public List<Resident> search(String key, String value) {
        //获取连接
        Connection connection = JDBCUtil.getConnection();
        String sql = "select * from resident where " + key + " like '%" + value + "%'";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        //定义居民信息集合
        List<Resident> list = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String name = resultSet.getString("resident_name");
                String phone = resultSet.getString("resident_phone");
                String houseNumber = resultSet.getString("resident_houseNumber");
                String gender = resultSet.getString("resident_gender");
                int id = resultSet.getInt("resident_index");
                //传入参数
                list.add(new Resident(id, name, phone, houseNumber, gender));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtil.close(connection, preparedStatement, resultSet);
        }
        return list;
    }

    //社区人员管理添加功能
    @Override
    public Integer addResident(Resident resident) {
        //获取连接
        Connection connection = JDBCUtil.getConnection();
        String sql = "insert into resident(resident_name,resident_phone,resident_housenumber,resident_gender) values(?,?,?,?)";
        PreparedStatement preparedStatement = null;
        Integer result = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, resident.getResident_name());
            preparedStatement.setString(2, resident.getResident_phone());
            preparedStatement.setString(3, resident.getResident_houseNumber());
            preparedStatement.setString(4, resident.getResident_gender());
            result = preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtil.close(connection, preparedStatement, null);
        }
        return result;

    }

    //注册
    @Override
    public Integer register(User user) {
        //获取连接
        Connection connection = JDBCUtil.getConnection();
        String sql = "insert into user(user_name,user_password,user_ident) values(?,?,?)";
        PreparedStatement preparedStatement = null;
        Integer re = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getUser_name());
            preparedStatement.setString(2, user.getUser_password());
            preparedStatement.setString(3, user.getUser_ident());
            re = preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtil.close(connection, preparedStatement, null);
        }
        return re;
    }

    //社区人员管理修改功能
    @Override
    public Integer updateResident(Resident resident) {
        //获取连接
        Connection connection = JDBCUtil.getConnection();
        //考虑到序号作为resident表主码，因此对resident_index不做更新
        String sql = "update resident set resident_name=?,resident_phone=?, resident_houseNumber=?,resident_gender=? where resident_index=?";
        PreparedStatement preparedStatement = null;
        Integer re = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, resident.getResident_name());
            preparedStatement.setString(2, resident.getResident_phone());
            preparedStatement.setString(3, resident.getResident_houseNumber());
            preparedStatement.setString(4, resident.getResident_gender());
            preparedStatement.setInt(5, resident.getResident_index());
            re = preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtil.close(connection, preparedStatement, null);
        }
        return re;
    }

    //社区人员管理删除功能
    @Override
    public Integer del(Integer id) {
        //获取连接
        Connection connection = JDBCUtil.getConnection();
        String sql = "delete from resident where resident_index=" + id;
        PreparedStatement preparedStatement = null;
        Integer re = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            re = preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtil.close(connection, preparedStatement, null);
        }
        return re;
    }
}
