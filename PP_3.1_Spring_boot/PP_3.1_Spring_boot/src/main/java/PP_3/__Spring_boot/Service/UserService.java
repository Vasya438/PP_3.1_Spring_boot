package web.Service;

import web.Model.User;

import java.util.List;

public interface UserService {
    void addUser(User user);

    List<User> getAllUsers();

    User getUser(Integer id);

    void updateUser(User user);

    void deleteUser(Integer id);
}
