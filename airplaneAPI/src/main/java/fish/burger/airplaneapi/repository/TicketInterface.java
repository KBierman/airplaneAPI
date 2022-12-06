package fish.burger.airplaneapi.repository;

import fish.burger.airplaneapi.model.TicketModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface TicketInterface extends MongoRepository<TicketModel, String> {

    @Query("{'ticketNo':'?0'}")
    TicketModel findTicketByName(int ticketNo);

    List<TicketModel> findTicketModelsByFltNo(int fltNo);

    int countByFltNo(int fltNo);

    @Query("{'userID':?0}")
    List<TicketModel> findByUserID(String userID);

    @Query(value="{'_id': ?0}", delete = true)
    void deleteByUserID(int ticketNo);

    public long count();
}
