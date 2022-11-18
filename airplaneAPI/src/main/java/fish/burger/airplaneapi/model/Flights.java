package fish.burger.airplaneapi.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Flights {

    @Id
    private int flightNumber;

    private String origin;
    private String destination;
    private String depTime;
    private String arrTime;
    private int seatsAvailable;
    private String fare;
    private String flight_DateTime;
    private String aircraftType;
    private String flightStatus;
    private String statusDT;

    public Flights(int flightNumber, String origin, String destination, String depTime, String arrTime,
                   int seatsAvailable, String fare, String flight_DateTime, String aircraftType, String flightStatus,
                   String statusDT) {
        super();
        this.flightNumber = flightNumber;
        this.origin = origin;
        this.destination = destination;
        this.depTime = depTime;
        this.arrTime = arrTime;
        this.seatsAvailable = seatsAvailable;
        this.fare = fare;
        this.flight_DateTime = flight_DateTime;
        this.aircraftType = aircraftType;
        this.flightStatus = flightStatus;
        this.statusDT = statusDT;
    }

    public int getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(int flightNumber) {
        this.flightNumber = flightNumber;
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

    public String getDepTime() {
        return depTime;
    }

    public void setDepTime(String depTime) {
        this.depTime = depTime;
    }

    public String getArrTime() {
        return arrTime;
    }

    public void setArrTime(String arrTime) {
        this.arrTime = arrTime;
    }

    public int getSeatsAvailable() {
        return seatsAvailable;
    }

    public void setSeatsAvailable(int seatsAvailable) {
        this.seatsAvailable = seatsAvailable;
    }

    public String getFare() {
        return fare;
    }

    public void setFare(String fare) {
        this.fare = fare;
    }

    public String getFlight_DateTime() {
        return flight_DateTime;
    }

    public void setFlight_DateTime(String flight_DateTime) {
        this.flight_DateTime = flight_DateTime;
    }

    public String getAircraftType() {
        return aircraftType;
    }

    public void setAircraftType(String aircraftType) {
        this.aircraftType = aircraftType;
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

    public Flights() {
    }
}
