package fish.burger.airplaneapi;

import fish.burger.airplaneapi.model.FlightModel;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Array;
import java.util.List;

@RestController
@RequestMapping("/api")
public class FlightRestController {
    private FlightBLL flightBLL = new FlightBLL();

    @PostMapping("/flight/{fltno}")
    @ResponseBody
    public void createFlight(@RequestBody FlightModel flight, @PathVariable int fltno) {
        flight.setFltNo(fltno);
        flightBLL.createFlight(flight);
    }

    @PutMapping("/flight/{fltno}")
    public void updateFlight(@RequestBody FlightModel flight, @PathVariable int fltno) {
        flight.setFltNo(fltno);
        flightBLL.updateFlight(flight);
    }

    @GetMapping("/flights/{fltno}")
    public FlightModel readFlight(@PathVariable int fltno) {
        return flightBLL.readFlightByFltNo(fltno);
    }

    @GetMapping("/flight")
    public List<FlightModel> readAllFlights() {
        return flightBLL.readAllFlights();
    }

    @DeleteMapping("/flight")
    public void deleteByFlightId(int fltId) {
        flightBLL.deleteFlightByFltNo(fltId);
    }

    @GetMapping("/flight/**")
    @PreAuthorize("permitAll()")
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
