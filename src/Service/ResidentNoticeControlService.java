package Service;

import Members.Notice;

import java.util.List;

public interface ResidentNoticeControlService {
    public List<Notice> list();

    public List<Notice> search(String key, String value);

}
