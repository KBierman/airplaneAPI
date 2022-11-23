//package fish.burger.airplaneapi;
//
//import fish.burger.airplaneapi.model.Flights;
//import fish.burger.airplaneapi.repository.FlightInterface;
//
//public class MongoDBCRUD{
//    private static FlightInterface flI;
//
//    public static void start(FlightInterface fi){
//        flI = fi;
//    }
//
//    public static void createFlight(){
//        System.out.println("Data creation started...");
//        flI.save(new Flights(1,"Salt Lake City", "Detroit", " 2:41", "5:41", 10, "219 Dollars",
//                "May 29th", "Boeing 777", "Green", "May 2nd"));
//        flI.findAll().forEach(item -> System.out.println(getItemDetails(item)));
//        System.out.println("Data creation complete...");
//    }
//
//    public static String getItemDetails(Flights flight){
//
//        System.out.println(
//                "name : " + flight.getFlightNumber());
//        return "";
//    }
//
//}
