package Dao;

import Members.Message;

import java.util.List;

public interface ResidentMessageControlDao {
    public List<Message> list();

    public List<Message> search(String key, String value);

    public Integer addMessage(Message message);
}
