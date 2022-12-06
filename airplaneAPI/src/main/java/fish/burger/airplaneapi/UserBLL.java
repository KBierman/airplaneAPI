package fish.burger.airplaneapi;

import fish.burger.airplaneapi.model.UserModel;
import fish.burger.airplaneapi.repository.UserInterface;

import java.util.List;

public class UserBLL {
    // Interface for interacting with the DB
    static UserInterface userITF;

    // Use this function in AirplaneApiApplication.java
    public static void start(UserInterface userInterface) {
        userITF = userInterface;
    }

    // Create
    public boolean createUser(UserModel newUser) {
        if (findUserByUsername(newUser.getUsername()) != null) {
            System.out.println("'" + newUser.getUsername() + "' already exists!");
            return false;
        } else {
            userITF.save(newUser);
            System.out.println("'" + newUser.getUsername() + "' was created successfully!");
            return true;
        }
    }

    // Read
    public UserModel findUserByUsername(String username) {
        return userITF.findUserByUsername(username);
    }

    public List<UserModel> findAll() {
        return userITF.findAll();
    }

    // Update
    public void updateUser(UserModel updatedUser) {
        UserModel oldUser = findUserByUsername(updatedUser.getUsername());
        if (oldUser != null) {
            updatedUser.setUserID(oldUser.getUserID());
            updatedUser.setFirstName(oldUser.getFirstName());
            updatedUser.setLastName(oldUser.getLastName());
            updatedUser.setRoles(oldUser.getRoles());
            userITF.save(updatedUser);
            System.out.println("'" + updatedUser.getUsername() + "' was successfully updated!");
            return;
        }
        System.out.println("'" + updatedUser.getUsername() + "' doesn't exist!");
    }

    // Delete
    public void deleteUser(String username) {
        if (findUserByUsername(username) != null) {
            userITF.deleteById(username);
            System.out.println("'" + username + "' was deleted successfully!");
            return;
        }
        System.out.println("'" + username + "' doesn't exist!");
    }

    public UserModel findUser(String username){
        return userITF.findUserByUsername(username);
    }

    public void createAdmin(String id, String pass) {
        UserModel userModel = new UserModel();

        userModel.setAdmin(true);
        userModel.setUserID(id);
        userModel.setUserPassword(pass);
        createUser(userModel);
    }

    public void updateUserToAdmin(String id){
       UserModel userModel = findUserByUsername(id);
       userModel.setAdmin(true);
       updateUser(userModel);
    }
}