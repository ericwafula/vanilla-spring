package tech.ericwathome.vanillaspring.user;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Override
    public List<User> AllUsers() {
        return List.of(
                User.builder()
                        .firstName("Eric")
                        .lastName("Wathome")
                        .gender("Male")
                        .build(),
                User.builder()
                        .firstName("Brian")
                        .lastName("Wathome")
                        .gender("Male")
                        .build()
        );
    }
}
