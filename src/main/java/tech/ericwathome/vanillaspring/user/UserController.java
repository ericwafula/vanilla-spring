package tech.ericwathome.vanillaspring.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/users")
public class UserController {
    @Autowired
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public User addUser(@RequestBody User user){
        return userService.addUser(user);
    }

    @GetMapping
    public List<User> AllUsers(){
        return userService.AllUsers();
    }

    @GetMapping("{id}")
    public Optional<User> getUser(@PathVariable("id") Long id) throws IllegalAccessException {
        return userService.getUser(id);
    }

    @GetMapping("user/{username}")
    public User getUserByUsername(@PathVariable("username") String username) throws IllegalAccessException {
        return userService.getUserByUsername(username);
    }

    @PutMapping("{id}")
    public User editUser(@PathVariable("id") Long id, @RequestBody User user){

        return userService.updateUser(id, user);
    }

    @DeleteMapping("{id}")
    public String deleteUser(@PathVariable("id") Long id){

        userService.deleteUser(id);

        return "User deleted successfully";
    }
}
