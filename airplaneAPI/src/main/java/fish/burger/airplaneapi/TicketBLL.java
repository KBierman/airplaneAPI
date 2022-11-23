package fish.burger.airplaneapi;

import fish.burger.airplaneapi.model.Tickets;
import fish.burger.airplaneapi.repository.TicketInterface;

import java.util.ArrayList;

public class TicketBLL {

    static TicketInterface tkI;

    public static void start(TicketInterface ticketInterface) {
        tkI = ticketInterface;
    }

    //Arraylist of TicketModel
    ArrayList<Tickets> tickets = new ArrayList();

    //creates a ticket in the arraylist
    public void createTicket(Tickets ticket) {
        tickets.add(ticket);
    }

    //reads all tickets in the arraylist
    public ArrayList<Tickets> readTicket() {
        return tickets;
    }

    //updates a ticket in the arraylist
    public void updateTicket(Tickets ticket) {
        for(int i = 0; i < tickets.size(); i++) {
            if (tickets.get(i).getTicketNo() == ticket.getTicketNo()) {
                tickets.remove(tickets.get(i));
                tickets.add(ticket);
            }
        }
    }

    //deletes a ticket in the arraylist
    public void deleteTicket(int ticketNo) {
        for(int i = 0; i < tickets.size(); i++) {
            if (tickets.get(i).getTicketNo() == ticketNo) {
                tickets.remove(tickets.get(i));
            }
        }
    }
}
