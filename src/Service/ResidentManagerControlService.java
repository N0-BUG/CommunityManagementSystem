package Service;

import Members.Manager;
import Members.Resident;

import java.util.List;

public interface ResidentManagerControlService {
    public List<Manager> list();

    public List<Manager> search(String key, String value);
}
