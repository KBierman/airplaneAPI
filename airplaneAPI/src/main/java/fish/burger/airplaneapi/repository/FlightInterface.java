package fish.burger.airplaneapi.repository;

import fish.burger.airplaneapi.FlightModel;
import fish.burger.airplaneapi.model.Flights;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface FlightInterface extends MongoRepository<Flights, String> {

    @Query("{flightNumber:'?0'}")
    Flights findItemByName(int flightNumber);

    @Query(value="{category:'?0'}", fields="{'flightNumber' : 1, 'seatsAvailable' : 1}")
    List<Flights> findAll(String category);

    public long count();
}
