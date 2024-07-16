package Service;

import Members.Message;

import java.util.List;

public interface ResidentMessageControlService {
    public List<Message> list();

    public List<Message> search(String key, String value);

    public void addMessage(Message message);
}
