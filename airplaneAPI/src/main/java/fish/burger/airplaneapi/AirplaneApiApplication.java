package fish.burger.airplaneapi;

import fish.burger.airplaneapi.repository.FlightInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class AirplaneApiApplication implements CommandLineRunner {
    @Autowired
    FlightInterface flI;

    public static void main(String[] args) {
        SpringApplication.run(AirplaneApiApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        FlightBLL.start(flI);
    }

}
