package Dao.conduct;

import ConnectionTools.JDBCUtil;
import Dao.ResidentNoticeControlDao;
import Members.Notice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ResidentNoticeControlDaoConduct implements ResidentNoticeControlDao {
    //公告管理全局查询展示
    @Override
    public List<Notice> list() {
        //获取连接
        Connection connection = JDBCUtil.getConnection();
        String sql = "select * from notice";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        //定义公告信息集合
        List<Notice> list = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            //将查到的数据传入Notice对象
            while (resultSet.next()) {
                int id = resultSet.getInt("notice_index");
                String info = resultSet.getString("notice_info");
                String publisher = resultSet.getString("notice_publisher");
                String date = resultSet.getString("notice_date");
                //传入参数
                list.add(new Notice(id, info, publisher, date));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtil.close(connection, preparedStatement, resultSet);
        }
        return list;
    }

    @Override
    public List<Notice> search(String key, String value) {
        //获取连接
        Connection connection = JDBCUtil.getConnection();
        String sql = "select * from notice where " + key + " like '%" + value + "%'";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        //定义居民信息集合
        List<Notice> list = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("notice_index");
                String info = resultSet.getString("notice_info");
                String publisher = resultSet.getString("notice_publisher");
                String date = resultSet.getString("notice_date");
                //传入参数
                list.add(new Notice(id, info, publisher, date));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtil.close(connection, preparedStatement, resultSet);
        }
        return list;
    }
}
