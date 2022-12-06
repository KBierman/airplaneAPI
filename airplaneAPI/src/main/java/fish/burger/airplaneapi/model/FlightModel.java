package fish.burger.airplaneapi.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class FlightModel {

//    @Id
    private int fltNo;
    private String origin;
    private String destination;
    private String arrTime;
    private String depTime;
    private String aircraftType;
    private int seatsEmpty; //both are used so that you can see how full the flight is and if you can get a seat
    private int seatsFull;
    private double fare; //double as cost is in $1.00
    private String flightDate;
    private String flightStatus; //status are delayed, on-time, cancelled, departed, in air, expected, diverted, recovery, landed, arrived
    private String statusDT; //when status was last updated

    public FlightModel(int fltNo, String origin, String destination, String arrTime, String depTime, String aircraftType, int seatsEmpty, int seatsFull, double fare, String flightDate, String flightStatus, String statusDT) {
        this.fltNo = fltNo;
        this.origin = origin;
        this.destination = destination;
        this.arrTime = arrTime;
        this.depTime = depTime;
        this.aircraftType = aircraftType;
        this.seatsEmpty = seatsEmpty;
        this.seatsFull = seatsFull;
        this.fare = fare;
        this.flightDate = flightDate;
        this.flightStatus = flightStatus;
        this.statusDT = statusDT;
    }

    public FlightModel() {
    }

    public int getFltNo() {
        return fltNo;
    }

    public void setFltNo(int fltNo) {
        this.fltNo = fltNo;
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

    public String getArrTime() {
        return arrTime;
    }

    public void setArrTime(String arrTime) {
        this.arrTime = arrTime;
    }

    public String getDepTime() {
        return depTime;
    }

    public void setDepTime(String depTime) {
        this.depTime = depTime;
    }

    public String getAircraftType() {
        return aircraftType;
    }

    public void setAircraftType(String aircraftType) {
        this.aircraftType = aircraftType;
    }

    public int getSeatsEmpty() {
        return seatsEmpty;
    }

    public void setSeatsEmpty(int seatsEmpty) {
        this.seatsEmpty = seatsEmpty;
    }

    public int getSeatsFull() {
        return seatsFull;
    }

    public void setSeatsFull(int seatsFull) {
        this.seatsFull = seatsFull;
    }

    public double getFare() {
        return fare;
    }

    public void setFare(double fare) {
        this.fare = fare;
    }

    public String getFlightDate() {
        return flightDate;
    }

    public void setFlightDate(String flightDate) {
        this.flightDate = flightDate;
    }

    public String getFlightStatus() {
        return flightStatus;
    }

    public void setFlightStatus(String flightStatus) {
        this.flightStatus = flightStatus;
    }

    public String getStatusDT() {
        return statusDT;
    }

    public void setStatusDT(String statusDT) {
        this.statusDT = statusDT;
    }
}
