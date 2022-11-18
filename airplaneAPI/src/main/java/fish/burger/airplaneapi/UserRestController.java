package fish.burger.airplaneapi;

import fish.burger.airplaneapi.model.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserRestController {
    // UserBLL object
    private UserBLL userBLL = new UserBLL();

    // Create
    @PostMapping("/user")
    @ResponseBody
    public void createUser(@RequestBody User newUser) {
        userBLL.createUser(newUser);
    }

    // Read
    @GetMapping("/user")
    public List<User> findAllEntries() {
        return userBLL.findAll();
    }

    @GetMapping("/user/{userID}")
    public User findUserByID(@PathVariable int userID) {
        return userBLL.findUser(userID);
    }

    // Update
    @PutMapping("/user/{userID}")
    public void updateUser(@PathVariable int userID, @RequestBody User updatedUser) {
        updatedUser.setUserID(userID);
        userBLL.updateUser(updatedUser);
    }

    // Delete
    @DeleteMapping("/user/{userID}")
    public void delete(@PathVariable int userID) {
        userBLL.deleteUser(userID);
    }
}
