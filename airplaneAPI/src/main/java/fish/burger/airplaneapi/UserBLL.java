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
    public void createUser(UserModel newUser) {
        if (findUserByID(newUser.getUserID()) != null) {
            System.out.println("'" + newUser.getUserID() + "' already exists!");
            return;
        }
        userITF.save(newUser);
        System.out.println("'" + newUser.getUserID() + "' was created successfully!");
    }

    // Read
    public UserModel findUserByID(String userID) {
        return userITF.findUserByID(userID);
    }

    public List<UserModel> findAll() {
        return userITF.findAll();
    }

    // Update
    public void updateUser(UserModel updatedUser) {
        if (findUserByID(updatedUser.getUserID()) != null) {
            userITF.save(updatedUser);
            System.out.println("'" + updatedUser.getUserID() + "' was successfully updated!");
            return;
        }
        System.out.println("'" + updatedUser.getUserID() + "' doesn't exist!");
    }

    // Delete
    public void deleteUser(String userID) {
        if (findUserByID(userID) != null) {
            userITF.deleteById(userID);
            System.out.println("'" + userID + "' was deleted successfully!");
            return;
        }
        System.out.println("'" + userID + "' doesn't exist!");
    }
}