package fish.burger.airplaneapi;

import fish.burger.airplaneapi.model.FlightModel;
import fish.burger.airplaneapi.repository.FlightInterface;
import org.springframework.data.mongodb.core.aggregation.ArrayOperators;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FlightBLL {

    static FlightInterface flI;

    public static void start(FlightInterface flightInterface) {
        flI = flightInterface;
    }

    public boolean createFlight(FlightModel flightModel) {
        if (flI.findFlightByFltNo(flightModel.getFltNo()) != null){
            return false;
        }
        flI.save(flightModel);
        return true;
    }

    public List<FlightModel> readAllCorrespondingFlights(String origin, String destination, String flightDate) {
        return flI.findCorresponding(origin, destination,flightDate);
    }

    public FlightModel readFlightByFltNo(int fltNo) {
        System.out.println(flI.findFlightByFltNo(fltNo));
        return flI.findFlightByFltNo(fltNo);
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
        return flI.findFlightByFltNo(fltNo) == null;
    }

    public String cancelFlight(int id){
        FlightModel flightModel = flI.findFlightByFltNo(id);
        flightModel.setFlightStatus("Cancelled");
        flightModel.setFlightDate(LocalDate.now().toString());
        updateFlight(flightModel);
        return flI.findFlightByFltNo(id).getFlightStatus();
    }

    public List<FlightModel> getLastMonthsFlights(){
        LocalDate local = LocalDate.now().minusMonths(1);
        System.out.println("(" + local.getMonthValue() + "\\/).*(\\/" + local.getYear() + ")");
        return flI.findFlightModelsByFlightDateIsLike(local.getMonthValue()+"/");
    }

    public List<Object> getReport(){
        List<FlightModel> monthlyReports = getLastMonthsFlights();
        System.out.println(monthlyReports);
        List<String> destinations = new ArrayList<>();
        List<Integer> amounts = new ArrayList<>();
        for (FlightModel fm : monthlyReports){
            if (!destinations.contains(fm.getDestination())){
                destinations.add(fm.getDestination());
            }
            for (int i = 0; i < destinations.size(); i++) {
                if(destinations.get(i).equals(fm.getDestination())){
                    if (amounts.size() == i){
                        amounts.add(1);
                    }else{
                        amounts.set(i, amounts.get(i)+1);
                    }
                }
            }
        }
        List<Object> finalVal = new ArrayList<>();
        finalVal.add(destinations);
        finalVal.add(amounts);
        System.out.println(finalVal);
        return finalVal;
    }
}
