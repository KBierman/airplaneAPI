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
        List<FlightModel> flL = flI.findAll();
        for (FlightModel flight : flL){
            if (flight.getFlightNumber() == flightModel.getFlightNumber()){
                return false;
            }
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

    public boolean updateFlight(FlightModel flight) {
        FlightModel flightModel = flI.save(flight);
        if (flightModel == null){
            return false;
        }
        return false;
    }

    public boolean deleteFlightByFltNo(int fltNo) {
        flI.deleteById(String.valueOf(fltNo));
        return flI.findFlightByNumber(fltNo) == null;
    }
}
