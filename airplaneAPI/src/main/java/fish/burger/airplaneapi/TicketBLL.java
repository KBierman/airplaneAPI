package fish.burger.airplaneapi;

import fish.burger.airplaneapi.model.FlightModel;
import fish.burger.airplaneapi.model.TicketModel;
import fish.burger.airplaneapi.repository.TicketInterface;
import org.springframework.data.mongodb.core.aggregation.ArrayOperators;

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
        tkI.deleteByUserID(ticket.getTicketNo());
        tkI.save(ticket);
    }

    //deletes a ticket in the mongoDB
    public boolean deleteTicket(int ticketNo) {
        //deleteByUserID in TicketInterface.java
        tkI.deleteByUserID(ticketNo);
        return tkI.findTicketByName(ticketNo) == null;
    }

    public List<Object> getReport(List<FlightModel> flightModelList){
        List<Object> finalVal = new ArrayList<>();
        List<String> destinations = new ArrayList<>();
        List<Integer> counts = new ArrayList<>();
        for (FlightModel flightModel: flightModelList){
            if (!destinations.contains(flightModel.getDestination())){
                destinations.add(flightModel.getDestination());
            }
            for (int i = 0; i < destinations.size(); i++) {
                if(destinations.get(i).equals(flightModel.getDestination())){
                    if (counts.size() == i){
                        counts.add(tkI.countByFltNo(flightModel.getFltNo()));
                    }else{
                        counts.set(i, counts.get(i)+ tkI.countByFltNo(flightModel.getFltNo()));
                    }
                }
            }
        }
        finalVal.add(destinations);
        finalVal.add(counts);
        System.out.println(finalVal);
        return finalVal;
    }

    public List<Object> getLastMonthCosts(List<FlightModel> flightModelList){
        List<Object> finalVal = new ArrayList<>();
        List<String> destinations = new ArrayList<>();
        List<Double> counts = new ArrayList<>();
        for (FlightModel flightModel: flightModelList){
            List<TicketModel> tickets = tkI.findTicketModelsByFltNo(flightModel.getFltNo());
            double count = 0.0;
            for (TicketModel ticket : tickets){
                count += ticket.getFare();
            }
            if (!destinations.contains(flightModel.getDestination())){
                destinations.add(flightModel.getDestination());
                counts.add(count);
            }else {
                for (int i = 0; i < destinations.size(); i++) {
                    if(destinations.get(i).equals(flightModel.getDestination())){
                        counts.set(i, counts.get(i)+count);
                    }
                }
            }
        }
        finalVal.add(destinations);
        finalVal.add(counts);
        System.out.println(finalVal);
        return finalVal;
    }

    //Needs a query to set ticket status as cancelled
    public void cancelTickets(int flightID, String user){
        List<TicketModel> ticketModels = tkI.findTicketModelsByFltNo(flightID);
        for (TicketModel ticket : ticketModels){
            ticket.setStatus("Cancelled");
            ticket.setReservedBy(user);
            updateTicket(ticket);
        }
    }
}
