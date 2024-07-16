package Service;

import Members.Floor;

import java.util.List;

public interface FloorControlService {
    public List<Floor> list();

    public List<Floor> search(String key, String value);

    public void addFloor(Floor floor);

    public void updateFloor(Floor floor);

    public void del(Integer id);
}
