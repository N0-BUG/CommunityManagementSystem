package Service.conduct;

import Dao.MessageControlDao;
import Dao.conduct.MessageControlDaoConduct;
import Members.Message;
import Service.MessageControlService;

import java.util.List;

public class MessageControlServiceConduct implements MessageControlService {
    private MessageControlDao messageControlDao = new MessageControlDaoConduct();

    @Override
    public List<Message> list() {
        return this.messageControlDao.list();
    }

    @Override
    public List<Message> search(String key, String value) {
        if (key.equals("")) return this.messageControlDao.list();
        return this.messageControlDao.search(key, value);
    }


    @Override
    public void addMessage(Message message) {
        Integer add = this.messageControlDao.addMessage(message);
        if (add != 1) throw new RuntimeException("楼宇信息添加失败");
    }

    @Override
    public void updateMessage(Message message) {
        Integer add = this.messageControlDao.updateMessage(message);
        if (add != 1) throw new RuntimeException("楼宇信息添加失败");
    }

    @Override
    public void del(Integer id) {
        Integer add = this.messageControlDao.del(id);
        if (add != 1) throw new RuntimeException("楼宇信息删除失败");
    }
}
