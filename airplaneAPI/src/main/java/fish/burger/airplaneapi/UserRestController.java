package fish.burger.airplaneapi;

import fish.burger.airplaneapi.model.UserModel;
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
    public void createUser(@RequestBody UserModel newUser) {
        userBLL.createUser(newUser);
    }

    // Read
    @GetMapping("/user")
    public List<UserModel> findAllEntries() {
        return userBLL.findAll();
    }

    @GetMapping("/user/{userID}")
    public UserModel findUserByID(@PathVariable String userID) {
        return userBLL.findUserByID(userID);
    }

    // Update
    @PutMapping("/user")
    public void updateUser(@RequestParam String userID, @RequestBody UserModel updatedUser) {
        updatedUser.setUserID(userID);
        userBLL.updateUser(updatedUser);
    }

    // Delete
    @DeleteMapping("/user")
    public void delete(@RequestParam String userID) {
        userBLL.deleteUser(userID);
    }
}
