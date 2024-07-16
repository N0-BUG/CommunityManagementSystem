package Dao;

import Members.Resident;
import Members.User;

import java.util.List;

public interface ManagerControlDao {
    public List<Resident> list();

    public List<Resident> search(String key, String value);

    public Integer addResident(Resident resident);

    public Integer register(User user);

    public Integer updateResident(Resident resident);

    public Integer del(Integer id);
}
