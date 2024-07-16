package Dao;

import Members.Floor;

import java.util.List;

public interface FloorControlDao {
    public List<Floor> list();

    public List<Floor> search(String key, String value);

    public Integer addFloor(Floor floor);

    public Integer updateFloor(Floor floor);

    public Integer del(Integer id);
}
