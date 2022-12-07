package fish.burger.airplaneapi;

import fish.burger.airplaneapi.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserRestController {

    // UserBLL object
    private UserBLL userBLL = new UserBLL();

    // Create
    @PostMapping("/user")
    @ResponseBody
    public boolean createUser(@RequestBody UserModel newUser) {
        return userBLL.createUser(newUser);
    }

    @GetMapping("/login")
    public void login(){

    }

    @GetMapping("/adminLogin")
    public void admin(){

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

    @PutMapping("/users/{id}/{pass}")
    public void createNewAdmin(@PathVariable String id,@PathVariable String pass){
        userBLL.createAdmin(id, pass);
    }

    @PutMapping("/users/{id}")
    public void updateUserToAdmin(@PathVariable String id){
        userBLL.updateUserToAdmin(id);
    }

    @PutMapping("/users/delete/{id}")
    public void deleteUser(@PathVariable String id){
        userBLL.deleteUser(id);
    }

}