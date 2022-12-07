package fish.burger.airplaneapi;

import fish.burger.airplaneapi.repository.FlightInterface;
import fish.burger.airplaneapi.repository.TicketInterface;
import fish.burger.airplaneapi.repository.UserInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication

@EnableMongoRepositories
public class AirplaneApiApplication implements CommandLineRunner {
    @Autowired
    FlightInterface flI;

    @Autowired
    TicketInterface tkI;

    @Autowired
    UserInterface userITF;

    public static void main(String[] args) {
        SpringApplication.run(AirplaneApiApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        FlightBLL.start(flI);
        TicketBLL.start(tkI);
        UserBLL.start(userITF);
    }

}
