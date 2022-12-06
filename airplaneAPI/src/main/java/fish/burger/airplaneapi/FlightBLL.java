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
        System.out.println(flightModel.getFltNo());
        if (flI.findByFltNo(flightModel.getFltNo()) != null){
            System.out.println("ballls");
            return false;
        }
        flI.save(flightModel);
        return true;
    }

    public List<FlightModel> readAllCorrespondingFlights(String origin, String destination, String flightDate) {
        return flI.findCorresponding(origin, destination,flightDate);
    }

    public FlightModel readFlightByFltNo(int fltNo) {
        System.out.println(flI.findByFltNo(fltNo));
        return flI.findByFltNo(fltNo);
    }

    public List<FlightModel> readAllFlights() {
        return flI.findAll();
    }

    public void updateFlight(FlightModel flight) {
        flI.deleteFLightByFlightID(flight.getFltNo());
        flI.save(flight);
    }

    public boolean deleteFlightByFltNo(int fltNo) {
        flI.deleteFLightByFlightID(fltNo);
        return flI.findByFltNo(fltNo) == null;
    }

    public String cancelFlight(int id){
        flI.setFlightStatusAndFlightDateWhereFltNo("Cancelled", "get date", id);
        return flI.findByFltNo(id).getFlightStatus();
    }

}
