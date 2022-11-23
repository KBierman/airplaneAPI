package fish.burger.airplaneapi;

import fish.burger.airplaneapi.model.UserModel;
import fish.burger.airplaneapi.repository.UserInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
            System.out.println("User already exists!");
            return;
        }

        userITF.save(newUser);
        System.out.println("User created successfully!");
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
        if (Objects.equals(findUserByID(updatedUser.getUserID()).getUserID(), updatedUser.getUserID())) {
            userITF.save(updatedUser);
            System.out.println("Updated user successfully!");
        } else {
            System.out.println("User doesn't exist!");
        }
    }

    // Delete
    public void deleteUser(String userID) {
        userITF.deleteById(userID);
        if (findUserByID(userID) == null) {
            System.out.println("User was deleted successfully!");
        } else {
            System.out.println("User couldn't be deleted!");
        }
    }
}