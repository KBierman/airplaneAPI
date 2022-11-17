package fish.burger.airplaneapi;

import java.io.PrintStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class FlightBLL {

    private List<FlightModel> fltList = new ArrayList<>();

    public boolean createFlight(int fltNo, String origin, String destination, String arrTime, String depTime, String aircraftType, int seatsEmpty, int seatsFull, double fare, String flightDate, String flightStatus, String statusDT) {
        for (FlightModel flt : fltList) {
            if (flt.getFlightNumber() == fltNo) {
                return false;
            }
        }
        fltList.add(new FlightModel(fltNo, origin, destination, arrTime, depTime, aircraftType, seatsEmpty, seatsFull, fare, flightDate, flightStatus, statusDT));
        return true;
    }

    public List<FlightModel> findAllCorrespondingFlights(String origin, String destination, String flightDate) {
        try {
            List<FlightModel> flights = new ArrayList<>();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
            for (FlightModel flt : fltList) {
                if (flt.getOrigin() == origin && flt.getDestination() == destination && sdf.parse(flightDate).equals(sdf.parse(flt.getFlightDate()))) {
                    flights.add(flt);
                }
            }
            return flights;
        } catch (ParseException p) {
            ;
            p.printStackTrace();
        }
        return null;
    }

    public FlightModel readFlightByFltNo(int fltNo) {
        for (FlightModel flt : fltList) {
            if (flt.getFlightNumber() == fltNo) {
                return flt;
            }
        }
        return null;
    }

    public List<FlightModel> readAllFlights() {
        return fltList;
    }

    public boolean updateFlight(FlightModel flight) {
        for (FlightModel flt : fltList) {
            if (flt.getFlightNumber() == flight.getFlightNumber()) {
                fltList.remove(flt);
                fltList.add(flight);
                return true;
            }
        }
        return false;
    }

    public boolean deleteFlightByFltNo(int FltNo) {
        for (FlightModel flt : fltList) {
            if (flt.getFlightNumber() == FltNo) {
                fltList.remove(flt);
                return true;
            }
        }
        return false;
    }
}
