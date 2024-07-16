package Service;

import Members.Message;

import java.util.List;

public interface MessageControlService {
    public List<Message> list();

    public List<Message> search(String key, String value);

    public void addMessage(Message message);

    public void updateMessage(Message message);

    public void del(Integer id);
}
