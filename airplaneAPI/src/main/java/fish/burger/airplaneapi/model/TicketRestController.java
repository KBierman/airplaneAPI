package fish.burger.airplaneapi.model;

import fish.burger.airplaneapi.TicketBLL;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TicketRestController {

    private TicketBLL ticketBLL = new TicketBLL();

    @PostMapping("/ticket")
    @ResponseBody
    public void createTicket(@RequestBody TicketModel ticket) {
        ticketBLL.createTicket(ticket);
    }

    @GetMapping("/ticket/{userID}")
    @ResponseBody
    public List<TicketModel> readAllTicketsFromUser(@PathVariable String userID) {
        return ticketBLL.readTicketsFromUser(userID);
    }

    @DeleteMapping("/ticket/{ticketNo}")
    @ResponseBody
    public boolean deleteTicket(@PathVariable int ticketNo) {
        return ticketBLL.deleteTicket(ticketNo);
    }

}
