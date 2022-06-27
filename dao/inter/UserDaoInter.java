package database.dao.inter;

import database.entity.User;

public interface UserDaoInter {
    boolean addUser(User u);
    int getIdByUser(User u);
}
