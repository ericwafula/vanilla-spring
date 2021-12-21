package tech.ericwathome.vanillaspring.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> AllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User addUser(User user) {
        List<User> usersList = userRepository.findAll();

        usersList.forEach(userDB -> {
            if (userDB.getUserName().equals(user.getUserName())){
                try {
                    throw new IllegalAccessException("username already exists");
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        });

        return userRepository.save(user);
    }

    @Override
    public Optional<User> getUser(Long id) throws IllegalAccessException {
        Optional<User> user = userRepository.findById(id);

        if (user.isEmpty()){
            throw new IllegalAccessException("User not found");
        }

        return user;
    }

    @Override
    public User getUserByUsername(String username) throws IllegalAccessException {

        User user = userRepository.findUserByUserName(username);

        if (user.getUserName().isEmpty()){
            throw new IllegalAccessException("User does not exist");
        }

        return user;
    }

    @Override
    public User updateUser(Long id, User user) {
        User userDB = userRepository.findById(id).get();

        if (Objects.nonNull(user.getFirstName()) && !"".equalsIgnoreCase(user.getFirstName())){
            userDB.setFirstName(user.getFirstName());
        }

        if(Objects.nonNull(user.getLastName()) && !"".equalsIgnoreCase(user.getLastName())){
            userDB.setLastName(user.getLastName());
        }

        if (Objects.nonNull(user.getAge()) && !"".equalsIgnoreCase(user.getAge().toString())){
            userDB.setAge(user.getAge());
        }

        if (Objects.nonNull(user.getGender()) && !"".equalsIgnoreCase(user.getGender())){
            userDB.setGender(user.getGender());
        }

        return userRepository.save(userDB);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
