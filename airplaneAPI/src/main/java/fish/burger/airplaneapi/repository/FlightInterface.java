package fish.burger.airplaneapi.repository;

import fish.burger.airplaneapi.model.FlightModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface FlightInterface extends MongoRepository<FlightModel, String> {

    @Query("{'fltNo':?0}")
    FlightModel findFlightByFltNo(int fltNo);

    @Query("{'origin':?0, 'destination':?1, 'flightDate':?2}")
    List<FlightModel> findCorresponding(String origin, String destination, String flightDate);

    public long count();

    @Query(value = "{'fltNo':?0}", delete=true)
    void deleteFLightByFlightID(int id);

    List<FlightModel> findFlightModelsByFlightDateRegex(String regex);
}
