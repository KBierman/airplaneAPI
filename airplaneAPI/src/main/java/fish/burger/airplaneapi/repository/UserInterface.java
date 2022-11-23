package fish.burger.airplaneapi.repository;

import fish.burger.airplaneapi.model.UserModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface UserInterface extends MongoRepository<UserModel, String> {
    @Query("{'userID':'?0'}")
    UserModel findUserByID(String userID);

    public long count();
}
