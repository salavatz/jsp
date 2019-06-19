package dao;

import entity.User;

public interface UserDAO {

    boolean userIsExist(String loging, String password);

    boolean addUser(User user);
}
