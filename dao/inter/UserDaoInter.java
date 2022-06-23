package dao.inter;

import entity.Country;
import entity.Skill;
import entity.User;
import entity.UserSkill;

import java.util.List;

public interface UserDaoInter {
    public User getUserById(int userId);
    public List<User> getAllUsers();

    public boolean addUser(User u);

    public boolean updateUser(User u);

    public boolean removeUser(int id);
}
