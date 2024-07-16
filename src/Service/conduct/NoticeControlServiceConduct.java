package Service.conduct;

import Dao.NoticeControlDao;
import Dao.conduct.NoticeControlDaoConduct;
import Members.Notice;
import Service.NoticeControlService;

import java.util.List;

public class NoticeControlServiceConduct implements NoticeControlService {
    private NoticeControlDao noticeControlDao = new NoticeControlDaoConduct();

    @Override
    public List<Notice> list() {
        return this.noticeControlDao.list();
    }

    @Override
    public List<Notice> search(String key, String value) {
        if (key.equals("")) return this.noticeControlDao.list();
        return this.noticeControlDao.search(key, value);
    }


    @Override
    public void addNotice(Notice notice) {
        Integer add = this.noticeControlDao.addNotice(notice);
        if (add != 1) throw new RuntimeException("楼宇信息添加失败");
    }

    @Override
    public void updateNotice(Notice notice) {
        Integer add = this.noticeControlDao.updateNotice(notice);
        if (add != 1) throw new RuntimeException("楼宇信息添加失败");
    }

    @Override
    public void del(Integer id) {
        Integer add = this.noticeControlDao.del(id);
        if (add != 1) throw new RuntimeException("楼宇信息删除失败");
    }
}
