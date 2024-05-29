package PP_3.__Spring_boot.dao;

import PP_3.__Spring_boot.model.User;

import java.util.ArrayList;
import java.util.List;

public interface UserDao {
    void addUser(User user);

    List<User> getAllUsers();
    User getUser(Integer id);
    void updateUser(User user);
    void deleteUser(Integer id);
}
