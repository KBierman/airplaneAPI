package fish.burger.airplaneapi.model;

import fish.burger.airplaneapi.FlightBLL;
import fish.burger.airplaneapi.TicketBLL;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TicketRestController {

    private TicketBLL ticketBLL = new TicketBLL();

    @PostMapping("/ticket")
    @ResponseBody
    public void CreateTicket(@RequestBody TicketModel ticket) {
        ticketBLL.createTicket(ticket);
    }

    @GetMapping("/ticket/{userID}")
    @ResponseBody
    public List<TicketModel> readAllTicketsFromUsers(@PathVariable String userID) {
        return ticketBLL.readTicketsFromUser(userID);
    }

    @DeleteMapping("/ticket/{ticketNo}")
    @ResponseBody
    public boolean deleteTicket(@PathVariable int ticketNo) {
        return ticketBLL.deleteTicket(ticketNo);
    }

}
