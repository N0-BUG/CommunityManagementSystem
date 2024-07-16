package Dao;

import Members.Message;
import Members.Notice;

import java.util.List;

public interface NoticeControlDao {
    public List<Notice> list();

    public List<Notice> search(String key, String value);

    public Integer addNotice(Notice notice);

    public Integer updateNotice(Notice notice);

    public Integer del(Integer id);
}
