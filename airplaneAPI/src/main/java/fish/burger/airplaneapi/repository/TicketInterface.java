package fish.burger.airplaneapi.repository;

import fish.burger.airplaneapi.FlightModel;
import fish.burger.airplaneapi.model.Tickets;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface TicketInterface extends MongoRepository<Tickets, String> {

    @Query("{ticketNo:'?0'}")
    Tickets findItemByName(int ticketNo);

    @Query(value="{category:'?0'}", fields="{'ticketNo' : 1, 'fltNo' : 1}")
    List<Tickets> findAll(String category);

    public long count();
}
