package fish.burger.airplaneapi.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class TicketModel {
    private int ticketNo;
    private int fltNo;
    private String dateOfJourney;
    private String userID;
    private String firstName;
    private String lastName;
    private String email;
    private double fare;
    private String status;
    private String reservedBy;
    private String dateOfReservation;

    public TicketModel() {
    }

    public TicketModel(int ticketNo, int fltNo, String dateOfJourney, String userID, String firstName, String lastName, String email, double fare, String status, String reservedBy, String dateOfReservation) {
        this.ticketNo = ticketNo;
        this.fltNo = fltNo;
        this.dateOfJourney = dateOfJourney;
        this.userID = userID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.fare = fare;
        this.status = status;
        this.reservedBy = reservedBy;
        this.dateOfReservation = dateOfReservation;
    }

    public int getTicketNo() {
        return ticketNo;
    }

    public void setTicketNo(int ticketNo) {
        this.ticketNo = ticketNo;
    }

    public int getFltNo() {
        return fltNo;
    }

    public void setFltNo(int fltNo) {
        this.fltNo = fltNo;
    }

    public String getDateOfJourney() {
        return dateOfJourney;
    }

    public void setDateOfJourney(String dateOfJourney) {
        this.dateOfJourney = dateOfJourney;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getFare() {
        return fare;
    }

    public void setFare(double fare) {
        this.fare = fare;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getReservedBy() {
        return reservedBy;
    }

    public void setReservedBy(String reservedBy) {
        this.reservedBy = reservedBy;
    }

    public String getDateOfReservation() {
        return dateOfReservation;
    }

    public void setDateOfReservation(String dateOfReservation) {
        this.dateOfReservation = dateOfReservation;
    }
}
