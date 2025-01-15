package web.dao;

import web.models.User;

import java.util.List;

public interface UserDao {
    List<User> getAllUsers();
    void createUser(User user);
    User getUserById(int id);
    void updateUser(User user, int id);
    void deleteUserById(int id);
}
