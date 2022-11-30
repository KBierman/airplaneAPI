package fish.burger.airplaneapi;

import fish.burger.airplaneapi.model.FlightModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class FlightRestController {
    private FlightBLL flightBLL = new FlightBLL();

    @GetMapping("/flight")
    @ResponseBody
    public void createFlight(@RequestBody FlightModel flight) {
        flightBLL.createFlight(flight);
    }

    @GetMapping("/flight/{flightFrom}/{flightTo}/{departureDate}")
    public List<FlightModel> readAllCorrespondingFlights(@PathVariable String flightFrom, @PathVariable String flightTo, @PathVariable String departureDate) {
        return flightBLL.readAllCorrespondingFlights(flightFrom, flightTo, departureDate);
    }
}
