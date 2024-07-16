package Service.conduct;

import Dao.FloorControlDao;
import Dao.conduct.FloorControlDaoConduct;
import Members.Floor;
import Service.FloorControlService;

import java.util.List;

public class FloorControlServiceConduct implements FloorControlService {
    private FloorControlDao floorControlDao = new FloorControlDaoConduct();

    @Override
    public List<Floor> list() {
        return this.floorControlDao.list();
    }

    @Override
    public List<Floor> search(String key, String value) {
        if (key.equals("")) return this.floorControlDao.list();
        return this.floorControlDao.search(key, value);
    }


    @Override
    public void addFloor(Floor floor) {
        Integer add = this.floorControlDao.addFloor(floor);
        if (add != 1) throw new RuntimeException("楼宇信息添加失败");
    }

    @Override
    public void updateFloor(Floor floor) {
        Integer add = this.floorControlDao.updateFloor(floor);
        if (add != 1) throw new RuntimeException("楼宇信息添加失败");
    }

    @Override
    public void del(Integer id) {
        Integer add = this.floorControlDao.del(id);
        if (add != 1) throw new RuntimeException("楼宇信息删除失败");
    }
}
