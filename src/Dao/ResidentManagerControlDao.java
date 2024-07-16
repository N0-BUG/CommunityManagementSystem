package Dao;

import Members.Manager;
import Members.Resident;

import java.util.List;

public interface ResidentManagerControlDao {
    public List<Manager> list();

    public List<Manager> search(String key, String value);
}
