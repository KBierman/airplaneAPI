package fish.burger.airplaneapi;

import fish.burger.airplaneapi.model.UserModel;
import fish.burger.airplaneapi.repository.UserInterface;

import java.util.ArrayList;
import java.util.List;

public class UserBLL {
//     Arraylist of UserModel java objects, will store information for/from database temporarily
    ArrayList<UserModel> userList = new ArrayList<>();
    static UserInterface userInterface;

    // Create
    public String createUser(UserModel newUser) {
        // Adds UserModel object to userList
//        userList.add(newUser);
        List<UserModel> usersFromDB = userInterface.findAll();
        for (UserModel user : usersFromDB){
            if (user.getUserID() == newUser.getUserID()){
                return "UserModel already exists!";
            }
        }

        userInterface.save(newUser);
        return "UserModel was successfully created!";
    }

    // Read
    public UserModel findUser(int userID) {
        // Lambda function, compares input userID and all userIDs in arraylist, then returns it.
        return findAll().stream().filter(um -> um.getUserID() == userID).findFirst().orElse(null);
    }

    public ArrayList<UserModel> findAll() {
        // Simply returns the current Arraylist
        return userList;
    }

    // Update
    public void updateUser(UserModel updatedUser) {
        for (UserModel um: userList) {
            // Replaces all fields with new fields from 'updatedUser', might do more specific update functions, such as password only or first and last name
            if (um.getUserID() == updatedUser.getUserID()) {
                um.setFirstName(updatedUser.getFirstName());
                um.setLastName(updatedUser.getLastName());
                um.setUserPassword(updatedUser.getUserPassword());
                um.setUserEmail(updatedUser.getUserEmail());
                um.setUserPhoneNumber(updatedUser.getUserPhoneNumber());
                um.setAdmin(updatedUser.getAdmin());
                um.setFareCollected(updatedUser.getFareCollected());
                um.setTimesFlown(updatedUser.getTimesFlown());
                System.out.println("Updated ID: " + um.getUserID());
            }
        }
    }

    // Delete
    public void deleteUser(int userID) {
        // Uses built in removeIf() function to check id and then remove user
        userList.removeIf(um -> um.getUserID() == userID);
    }
}