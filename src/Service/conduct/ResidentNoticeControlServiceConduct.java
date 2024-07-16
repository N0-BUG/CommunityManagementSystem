package Service.conduct;

import Dao.ResidentMessageControlDao;
import Dao.ResidentNoticeControlDao;
import Dao.conduct.ResidentMessageControlDaoConduct;
import Dao.conduct.ResidentNoticeControlDaoConduct;
import Members.Message;
import Members.Notice;
import Service.ResidentNoticeControlService;

import java.util.List;

public class ResidentNoticeControlServiceConduct implements ResidentNoticeControlService {
    private ResidentNoticeControlDao residentNoticeControlDao = new ResidentNoticeControlDaoConduct();

    @Override
    public List<Notice> list() {
        return this.residentNoticeControlDao.list();
    }

    @Override
    public List<Notice> search(String key, String value) {
        if (key.equals("")) return this.residentNoticeControlDao.list();
        return this.residentNoticeControlDao.search(key, value);
    }


}
