package Service.conduct;

import Dao.NoticeControlDao;
import Dao.ResidentManagerControlDao;
import Dao.conduct.NoticeControlDaoConduct;
import Dao.conduct.ResidentManagerControlDaoConduct;
import Members.Manager;
import Members.Message;
import Service.ResidentManagerControlService;

import java.util.List;

public class ResidentManagerControlServiceConduct implements ResidentManagerControlService {
    private ResidentManagerControlDao residentManagerControlDao = new ResidentManagerControlDaoConduct();
    @Override
    public List<Manager> list() {
        return this.residentManagerControlDao.list();
    }

    @Override
    public List<Manager> search(String key, String value) {
        if (key.equals("")) return this.residentManagerControlDao.list();
        return this.residentManagerControlDao.search(key, value);
    }
}
