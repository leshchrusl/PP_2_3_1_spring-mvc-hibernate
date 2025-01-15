package web.service;

import web.models.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    void createUser(User user);
    User getUserById(int id);
    void updateUser(User user);
    void deleteUserById(int id);
}
