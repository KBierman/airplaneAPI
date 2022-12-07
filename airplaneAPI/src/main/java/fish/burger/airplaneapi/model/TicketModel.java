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
    private String origin;
    private String destination;
    private String arrivalTime;
    private String departureTime;

    public TicketModel() {
    }

    public TicketModel(int ticketNo, int fltNo, String dateOfJourney, String userID, String firstName, String lastName, String email, double fare, String status, String reservedBy, String dateOfReservation, String origin, String destination, String arrivalTime, String departureTime) {
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
        this.origin = origin;
        this.destination = destination;
        this.arrivalTime = arrivalTime;
        this.departureTime = departureTime;
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

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }
}
