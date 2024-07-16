package Service;

import Members.Notice;

import java.util.List;

public interface NoticeControlService {
    public List<Notice> list();

    public List<Notice> search(String key, String value);

    public void addNotice(Notice notice);

    public void updateNotice(Notice notice);

    public void del(Integer id);
}
