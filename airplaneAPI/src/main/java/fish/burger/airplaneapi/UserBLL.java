package fish.burger.airplaneapi;

import java.util.ArrayList;

public class UserBLL {
    // Arraylist of User java objects, will store information for/from database temporarily
    ArrayList<UserModel> userList = new ArrayList<>();

    // Create
    public void createUser(UserModel newUser) {
        // Adds User object to userList
        userList.add(newUser);
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