package fish.burger.airplaneapi;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserRestController {
    private UserBLL userBLL = new UserBLL();

    // Create
    @PostMapping("/user")
    @ResponseBody
    public void createUser(@RequestBody UserModel newUser) {
        userBLL.createUser(newUser);
    }

    // Read
    @GetMapping("/user")
    public List<UserModel> findAllEntries() {
        return userBLL.findAll();
    }

    @GetMapping("/user/{userID}")
    public UserModel findUserByID(@PathVariable int userID) {
        return userBLL.findUser(userID);
    }

    // Update
    @PutMapping("/user/{userID}")
    public void updateUser(@PathVariable int userID, @RequestBody UserModel updatedUser) {
        updatedUser.setUserID(userID);
        userBLL.updateUser(updatedUser);
    }

    // Delete
    @DeleteMapping("/user/{userID}")
    public void delete(@PathVariable int userID) {
        userBLL.deleteUser(userID);
    }
}
