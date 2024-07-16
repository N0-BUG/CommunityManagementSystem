package Service.conduct;

import Dao.ManagerControlDao;
import Dao.conduct.ManagerControlDaoConduct;
import Members.Resident;
import Members.User;
import Service.ManagerControlService;

import java.util.List;

public class ManagerControlServiceConduct implements ManagerControlService {
    private ManagerControlDao managerControlDao = new ManagerControlDaoConduct();

    //全表查询
    @Override
    public List<Resident> list() {
        return this.managerControlDao.list();
    }

    //搜索
    @Override
    public List<Resident> search(String key, String value) {
        if (key.equals("")) return this.managerControlDao.list();
        return this.managerControlDao.search(key, value);
    }

    @Override
    public void addResident(Resident resident) {
        Integer add = this.managerControlDao.addResident(resident);
        if (add != 1) throw new RuntimeException("居民信息添加失败");
    }

    @Override
    public void register(User user) {
        Integer ad = this.managerControlDao.register(user);
        if (ad != 1) throw new RuntimeException("注册失败");
    }

    public void updateResident(Resident resident) {
        Integer up = this.managerControlDao.updateResident(resident);
        if (up != 1) throw new RuntimeException("更新失败");
    }

    @Override
    public void del(Integer id) {
        Integer del = this.managerControlDao.del(id);
        if (del != 1) throw new RuntimeException("删除失败");
    }
}
