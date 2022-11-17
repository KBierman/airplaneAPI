package fish.burger.airplaneapi;

import java.util.ArrayList;

public class TicketBLL {

    //Arraylist of TicketModel
    ArrayList<TicketModel> tickets = new ArrayList();

    //creates a ticket in the arraylist
    public void createTicket(TicketModel ticket) {
        tickets.add(ticket);
    }

    //reads all tickets in the arraylist
    public ArrayList<TicketModel> readTicket() {
        return tickets;
    }

    //updates a ticket in the arraylist
    public void updateTicket(TicketModel ticket) {
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
                tickets.remove(ticketNo);
            }
        }
    }
}
