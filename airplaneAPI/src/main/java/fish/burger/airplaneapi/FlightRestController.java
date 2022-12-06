package fish.burger.airplaneapi;

import fish.burger.airplaneapi.model.FlightModel;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Array;
import java.util.List;

@RestController
@RequestMapping("/api")
public class FlightRestController {
    private FlightBLL flightBLL = new FlightBLL();

    @GetMapping("/flight")
    @ResponseBody
    public void createFlight(@RequestBody FlightModel flight, @PathVariable int fltno) {
        flight.setFlightNumber(fltno);
        flightBLL.createFlight(flight);
    }

    @PutMapping("/flight/{fltno}")
    public void updateFlight(@RequestBody FlightModel flight, @PathVariable int fltno) {
        flight.setFlightNumber(fltno);
        flightBLL.updateFlight(flight);
    }

    @GetMapping("/flights/{user}")
    public FlightModel readFlight(@PathVariable int user) {
        return flightBLL.readFlightByFltNo(user);
    }

    @GetMapping("/flight")
    public List<FlightModel> readAllFlights() {
        return flightBLL.readAllFlights();
    }

    @DeleteMapping("/flight")
    public void deleteByFlightId(int fltId) {
        flightBLL.deleteFlightByFltNo(fltId);
    }
//    @PutMapping("")

//    @GetMapping("/flight/{flightFrom}/{flightTo}/{departureDate}")
//    public List<FlightModel> readAllCorrespondingFlights(@PathVariable String flightFrom, @PathVariable String flightTo, @PathVariable String departureDate) {
//        return flightBLL.readAllCorrespondingFlights(flightFrom, flightTo, departureDate);
//    }

    @GetMapping("/flight/**")
    @ResponseBody
    public List<FlightModel> readAllCorrespondingFlights(HttpServletRequest request) {
        String requestURL = request.getRequestURL().toString();

        String[] aryReq = requestURL.split("http://localhost:8080/api/");

        String localhostPart = aryReq[1];

        String[] aryOfRequestURL = localhostPart.split("/");

        String flightFrom = aryOfRequestURL[1].replace("%20", " ");
        String flightTo = aryOfRequestURL[2];
        String departureDate = aryOfRequestURL[3] + "/" + aryOfRequestURL[4] + "/" + aryOfRequestURL[5];


        return flightBLL.readAllCorrespondingFlights(flightFrom, flightTo, departureDate);
    }

    @GetMapping("/flight/{fltNo}")
    @ResponseBody
    public FlightModel readFlightByFlightNumber(@PathVariable int fltNo) {
        return flightBLL.readFlightByFltNo(fltNo);
    }
}
