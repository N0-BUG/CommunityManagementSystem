package Dao;

import Members.Notice;

import java.util.List;

public interface ResidentNoticeControlDao {
    public List<Notice> list();

    public List<Notice> search(String key, String value);
}
