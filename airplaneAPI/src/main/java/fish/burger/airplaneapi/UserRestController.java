package fish.burger.airplaneapi;

import fish.burger.airplaneapi.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserRestController {
    @Autowired
    public InMemoryUserDetailsManager inMemoryUserDetailsManager;

    @Autowired
    public PasswordEncoder passwordEncoder;

    // UserBLL object
    private UserBLL userBLL = new UserBLL();

    // Create
    @PostMapping("/user/{isAdmin}")
    @ResponseBody
    public boolean createUser(@RequestBody UserModel newUser, @PathVariable boolean isAdmin) {
        String[] roles = new String[1];
        roles[0] = "USER";

        newUser.setAdmin(isAdmin);
        newUser.setRoles(roles);
        System.out.println(newUser);

        inMemoryUserDetailsManager.createUser(User.withUsername(newUser.getUsername())
                .password(passwordEncoder.encode(newUser.getUserPassword()))
                .roles(roles[0]).build());
        return userBLL.createUser(newUser);
    }

    // Read
    @GetMapping("/user")
    public List<UserModel> findAllEntries() {
        return userBLL.findAll();
    }

    @GetMapping("/user/{username}")
    public UserModel findUserByUsername(@PathVariable String username) {
        return userBLL.findUserByUsername(username);
    }

    // This function will grab all users from database and put them in memory
    @GetMapping("/loadusers")
    public void loadAllusersInMemory() {
        List<UserModel> allUsers = findAllEntries();

        for (UserModel user : allUsers){
            inMemoryUserDetailsManager.createUser(User.withUsername(user.getUsername())
                    .password(passwordEncoder.encode(user.getUserPassword()))
                    .roles(user.getRoles()).build());
        }
    }

    // Update
    @PutMapping("/user/{username}")
    public void updateUser(@PathVariable String username, @RequestBody UserModel updatedUser) {
        updatedUser.setUsername(username);
        userBLL.updateUser(updatedUser);
    }

    // Delete
    @DeleteMapping("/user/{username}")
    public void delete(@PathVariable String username) {
        userBLL.deleteUser(username);
    }
}
