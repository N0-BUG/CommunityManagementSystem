package Service;

import Members.Resident;
import Members.User;

import java.util.List;

public interface ManagerControlService {
    public List<Resident> list();

    public List<Resident> search(String key, String value);

    public void addResident(Resident resident);

    public void register(User user);

    public void updateResident(Resident resident);

    public void del(Integer id);
}
