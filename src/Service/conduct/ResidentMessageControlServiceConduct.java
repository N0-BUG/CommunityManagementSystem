package Service.conduct;

import Dao.ResidentMessageControlDao;
import Dao.conduct.ResidentMessageControlDaoConduct;
import Members.Message;
import Service.ResidentMessageControlService;

import java.util.List;

public class ResidentMessageControlServiceConduct implements ResidentMessageControlService {
    private ResidentMessageControlDao residentMessageControlDao = new ResidentMessageControlDaoConduct();

    @Override
    public List<Message> list() {
        return this.residentMessageControlDao.list();
    }

    @Override
    public List<Message> search(String key, String value) {
        if (key.equals("")) return this.residentMessageControlDao.list();
        return this.residentMessageControlDao.search(key, value);
    }


    @Override
    public void addMessage(Message message) {
        Integer add = this.residentMessageControlDao.addMessage(message);
        if (add != 1) throw new RuntimeException("楼宇信息添加失败");
    }
}
