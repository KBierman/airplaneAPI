package fish.burger.airplaneapi;

import fish.burger.airplaneapi.model.TicketModel;
import fish.burger.airplaneapi.repository.TicketInterface;

import java.util.ArrayList;
import java.util.List;

public class TicketBLL {

    static TicketInterface tkI;

    public static void start(TicketInterface ticketInterface) {
        tkI = ticketInterface;
    }

    //Arraylist of TicketModel
    ArrayList<TicketModel> tickets = new ArrayList();

    //creates a ticket in the mongoDB
    public boolean createTicket(TicketModel ticketModel) {
        //findTicketByName in TicketInterface.java
        if(tkI.findTicketByName(ticketModel.getTicketNo())!= null) {
            return false;
            }
        tkI.save(ticketModel);
        return true;
    }

    //reads all tickets from a single owner in mongoDB
    public List<TicketModel> readTicketsFromUser(String userID) {
        //findByUserID in TicketInterface.java
        return tkI.findByUserID(userID);
    }

    //updates a ticket in mongoDB
    public void updateTicket(TicketModel ticket) {
        tkI.save(ticket);
    }

    //deletes a ticket in the mongoDB
    public boolean deleteTicket(int ticketNo) {
        //deleteByUserID in TicketInterface.java
        tkI.deleteByUserID(ticketNo);
        return tkI.findTicketByName(ticketNo) == null;
    }
}
