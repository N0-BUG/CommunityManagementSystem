package Dao.conduct;

import ConnectionTools.JDBCUtil;
import Dao.FloorControlDao;
import Members.Floor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FloorControlDaoConduct implements FloorControlDao {
    //楼宇管理全局查询展示
    @Override
    public List<Floor> list() {
        //获取连接
        Connection connection = JDBCUtil.getConnection();
        String sql = "select * from floor";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        //定义楼宇信息集合
        List<Floor> list = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            //将查到的数据传入Resident对象
            while (resultSet.next()) {
                int id = resultSet.getInt("floor_index");
                String no = resultSet.getString("floor_no");
                String manager = resultSet.getString("floor_manager");
                String host = resultSet.getString("floor_host");
                String houseNumber = resultSet.getString("floor_houseNumber");
                int sum = resultSet.getInt("floor_sum");
                //传入参数
                list.add(new Floor(id, no, manager, host, sum, houseNumber));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtil.close(connection, preparedStatement, resultSet);
        }
        return list;
    }

    @Override
    public List<Floor> search(String key, String value) {
        //获取连接
        Connection connection = JDBCUtil.getConnection();
        String sql = "select * from floor where " + key + " like '%" + value + "%'";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        //定义居民信息集合
        List<Floor> list = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("floor_index");
                String no = resultSet.getString("floor_no");
                String manager = resultSet.getString("floor_manager");
                String host = resultSet.getString("floor_host");
                String houseNumber = resultSet.getString("floor_houseNumber");
                int sum = resultSet.getInt("floor_sum");
                //传入参数
                list.add(new Floor(id, no, manager, host, sum, houseNumber));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtil.close(connection, preparedStatement, resultSet);
        }
        return list;
    }

    @Override
    public Integer addFloor(Floor floor) {
        //获取连接
        Connection connection = JDBCUtil.getConnection();
        String sql = "insert into floor(floor_no,floor_manager,floor_host,floor_houseNumber,floor_sum) values(?,?,?,?,?)";
        PreparedStatement preparedStatement = null;
        Integer result = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, floor.getFloor_no());
            preparedStatement.setString(2, floor.getFloor_manager());
            preparedStatement.setString(3, floor.getFloor_host());
            preparedStatement.setString(4, floor.getFloor_houseNumber());
            preparedStatement.setInt(5, floor.getFloor_sum());
            result = preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtil.close(connection, preparedStatement, null);
        }
        return result;
    }

    @Override
    public Integer updateFloor(Floor floor) {
        //获取连接
        Connection connection = JDBCUtil.getConnection();
        //考虑到序号作为resident表主码，因此对resident_index不做更新
        String sql = "update floor set floor_no=?,floor_manager=?,floor_host=?,floor_houseNumber=?,floor_sum=? where floor_index=?";
        PreparedStatement preparedStatement = null;
        Integer re = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, floor.getFloor_no());
            preparedStatement.setString(2, floor.getFloor_manager());
            preparedStatement.setString(3, floor.getFloor_host());
            preparedStatement.setString(4, floor.getFloor_houseNumber());
            preparedStatement.setInt(5, floor.getFloor_sum());
            preparedStatement.setInt(6, floor.getFloor_index());
            re = preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtil.close(connection, preparedStatement, null);
        }
        return re;
    }

    @Override
    public Integer del(Integer id) {
        //获取连接
        Connection connection = JDBCUtil.getConnection();
        String sql = "delete from floor where floor_index=" + id;
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
