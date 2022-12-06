package fish.burger.airplaneapi;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ReportRestController {
    // UserBLL object
    private UserBLL userBLL = new UserBLL();
    private FlightBLL flightBLL = new FlightBLL();
    private TicketBLL ticketBll = new TicketBLL();


    @GetMapping("/reports/flights")
    public List<Object> monthlyFlightReports() {
        return flightBLL.getReport();
    }

    @GetMapping("/reports/reservations")
    public List<Object> monthlyReservationsReports() {
        ticketBll.getReport(flightBLL.getLastMonthsFlights());
        return null;
    }

    @GetMapping("/reports/users")
    public List<Object> monthlyUsersReports() {
        //collective fare collected
        ticketBll.getLastMonthCosts(flightBLL.getLastMonthsFlights());
        return null;
    }

    @GetMapping("/reports/{user}/{id}")
    public void cancelFlight(String user, int flightId) {
        String fb = flightBLL.cancelFlight(flightId);
        if (fb == "Cancelled") {
            ticketBll.cancelTickets(flightId, user);
        }
    }
}