package tech.ericwathome.vanillaspring.user;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> AllUsers();

    User addUser(User user);

    Optional<User> getUser(Long id) throws IllegalAccessException;

    User getUserByUsername(String username) throws IllegalAccessException;

    User updateUser(Long id, User user);

    void deleteUser(Long id);
}
