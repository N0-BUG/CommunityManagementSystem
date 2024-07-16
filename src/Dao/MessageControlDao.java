package Dao;

import Members.Message;

import java.util.List;

public interface MessageControlDao {
    public List<Message> list();

    public List<Message> search(String key, String value);

    public Integer addMessage(Message message);

    public Integer updateMessage(Message message);

    public Integer del(Integer id);
}
