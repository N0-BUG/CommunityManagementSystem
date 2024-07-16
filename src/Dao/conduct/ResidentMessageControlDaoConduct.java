package Dao.conduct;

import ConnectionTools.JDBCUtil;
import Dao.ResidentMessageControlDao;
import Members.Message;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ResidentMessageControlDaoConduct implements ResidentMessageControlDao {
    //留言管理全局查询展示
    @Override
    public List<Message> list() {
        //获取连接
        Connection connection = JDBCUtil.getConnection();
        String sql = "select * from message";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        //定义楼宇信息集合
        List<Message> list = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            //将查到的数据传入Resident对象
            while (resultSet.next()) {
                int id = resultSet.getInt("message_index");
                String info = resultSet.getString("message_info");
                String publisher = resultSet.getString("message_publisher");
                String date = resultSet.getString("message_date");
                //传入参数
                list.add(new Message(id, info, publisher, date));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtil.close(connection, preparedStatement, resultSet);
        }
        return list;
    }

    @Override
    public List<Message> search(String key, String value) {
        //获取连接
        Connection connection = JDBCUtil.getConnection();
        String sql = "select * from message where " + key + " like '%" + value + "%'";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        //定义居民信息集合
        List<Message> list = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("message_index");
                String info = resultSet.getString("message_info");
                String publisher = resultSet.getString("message_publisher");
                String date = resultSet.getString("message_date");
                //传入参数
                list.add(new Message(id, info, publisher, date));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtil.close(connection, preparedStatement, resultSet);
        }
        return list;
    }

    @Override
    public Integer addMessage(Message message) {
        //获取连接
        Connection connection = JDBCUtil.getConnection();
        String sql = "insert into message(message_info,message_publisher,message_date) values(?,?,?)";
        PreparedStatement preparedStatement = null;
        Integer result = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, message.getMessage_info());
            preparedStatement.setString(2, message.getMessage_publisher());
            preparedStatement.setString(3, message.getMessage_date());
            result = preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtil.close(connection, preparedStatement, null);
        }
        return result;
    }

}
