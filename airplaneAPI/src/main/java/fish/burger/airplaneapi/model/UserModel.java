package fish.burger.airplaneapi.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class UserModel {

    @Id
    private String userID;
    private String firstName;
    private String lastName;
    private String userPassword;
    private String userEmail;
    private String userPhoneNumber;
    private Boolean isAdmin;
    private int fareCollected;
    private int timesFlown;

    public UserModel(String userID, String firstName, String lastName, String userPassword, String userEmail, String userPhoneNumber, Boolean isAdmin, int fareCollected, int timesFlown) {
        this.userID = userID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userPassword = userPassword;
        this.userEmail = userEmail;
        this.userPhoneNumber = userPhoneNumber;
        this.isAdmin = isAdmin;
        this.fareCollected = fareCollected;
        this.timesFlown = timesFlown;
    }

    public UserModel() {
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPhoneNumber() {
        return userPhoneNumber;
    }

    public void setUserPhoneNumber(String userPhoneNumber) {
        this.userPhoneNumber = userPhoneNumber;
    }

    public Boolean getAdmin() {
        return isAdmin;
    }

    public void setAdmin(Boolean admin) {
        isAdmin = admin;
    }

    public int getFareCollected() {
        return fareCollected;
    }

    public void setFareCollected(int fareCollected) {
        this.fareCollected = fareCollected;
    }

    public int getTimesFlown() {
        return timesFlown;
    }

    public void setTimesFlown(int timesFlown) {
        this.timesFlown = timesFlown;
    }
}
