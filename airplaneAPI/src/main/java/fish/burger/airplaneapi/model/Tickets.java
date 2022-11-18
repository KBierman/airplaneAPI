package fish.burger.airplaneapi.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Tickets {

    @Id
    private int ticketNo;
    private int fltNo;
    private String dateOfJourney;
    private String firstName;
    private String lastName;
    private String email;
    private double fare;
    private String status;
    private String reservedBy;
    private String DateOfReservation;
    private boolean ticketConfirmed;
    private boolean refund;
    private String processedBy;
    private String CancellationDate;


    public Tickets() {
    }

    public Tickets(int ticketNo, int fltNo, String dateOfJourney, String firstName, String lastName, String email, double fare, String status, String reservedBy, String dateOfReservation, boolean ticketConfirmed, boolean refund, String processedBy, String cancellationDate) {
        this.ticketNo = ticketNo;
        this.fltNo = fltNo;
        this.dateOfJourney = dateOfJourney;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.fare = fare;
        this.status = status;
        this.reservedBy = reservedBy;
        DateOfReservation = dateOfReservation;
        this.ticketConfirmed = ticketConfirmed;
        this.refund = refund;
        this.processedBy = processedBy;
        CancellationDate = cancellationDate;
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
        return DateOfReservation;
    }

    public void setDateOfReservation(String dateOfReservation) {
        DateOfReservation = dateOfReservation;
    }

    public boolean isTicketConfirmed() {
        return ticketConfirmed;
    }

    public void setTicketConfirmed(boolean ticketConfirmed) {
        this.ticketConfirmed = ticketConfirmed;
    }

    public boolean isRefund() {
        return refund;
    }

    public void setRefund(boolean refund) {
        this.refund = refund;
    }

    public String getProcessedBy() {
        return processedBy;
    }

    public void setProcessedBy(String processedBy) {
        this.processedBy = processedBy;
    }

    public String getCancellationDate() {
        return CancellationDate;
    }

    public void setCancellationDate(String cancellationDate) {
        CancellationDate = cancellationDate;
    }
}
