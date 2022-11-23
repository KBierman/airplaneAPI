package fish.burger.airplaneapi;

import fish.burger.airplaneapi.model.FlightModel;
import fish.burger.airplaneapi.repository.FlightInterface;

import java.util.List;

public class FlightBLL {

    static FlightInterface flI;

    public static void start(FlightInterface flightInterface) {
        flI = flightInterface;
    }

    public boolean createFlight(FlightModel flightModel) {
        if (flI.findFlightByNumber(flightModel.getFlightNumber()) != null){
            return false;
        }
        flI.save(flightModel);
        return true;
    }

    public List<FlightModel> readAllCorrespondingFlights(String origin, String destination, String flightDate) {
        return flI.findCorresponding(origin, destination,flightDate);
    }

    public FlightModel readFlightByFltNo(int fltNo) {
        return flI.findFlightByNumber(fltNo);
    }

    public List<FlightModel> readAllFlights() {
        return flI.findAll();
    }

    public void updateFlight(FlightModel flight) {
        flI.save(flight);
    }

    public boolean deleteFlightByFltNo(int fltNo) {
        flI.deleteById(String.valueOf(fltNo));
        return flI.findFlightByNumber(fltNo) == null;
    }
}
