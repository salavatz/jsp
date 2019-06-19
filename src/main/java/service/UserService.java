package service;

public interface UserService {

    boolean userIsExist(String loging, String password);

    boolean addUser(String login, String password);
}
