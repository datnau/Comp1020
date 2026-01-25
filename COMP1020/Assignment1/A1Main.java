public class A1Main {
 
    public static Airport createAirport(String code, String city, String country, int fee){
        Airport newAirport = new Airport(code, city, country, fee);
        return newAirport;
    }


    public static Flight createFlight(String code, Airport depart, Airport arrive){
        Flight newFlight = new Flight(code, depart, arrive);
        return newFlight;
    }


    public static Passenger createPassenger(String passengerName, String citizenship, int  yearOfBirth){
        Passenger newPassenger = new Passenger(passengerName, citizenship, yearOfBirth);
        return newPassenger;
    }


    public static Airport[] createAirports(String[] countryCode, String[] city, String[] country, int[] airportFee){
        Airport[] newAirportArray = new Airport[countryCode.length];
        for(int i = 0; i < countryCode.length; i++){
            newAirportArray[i] = new Airport(countryCode[i] , city[i], country[i], airportFee[i]);
        }
        return newAirportArray;
    }


    public static Airport findAirportCode(String code, Airport[] airports){
        for (int i = 0; i < airports.length; i++) {
            if(airports[i] != null && airports[i].matchesCode(code)){
                return airports[i];
            }
        }return null;
    }


    public static Airport findAirportCity(String city, Airport[] airports){
        for (int i = 0; i < airports.length; i++) {
            if(airports[i] != null && airports[i].matchesCity(city)){
                return airports[i];
            }
        }return null;
    }


    public static Flight[] createFlights(String[] flightCode, String[] departCode, String[] arriveCode, Airport[] airports){
         Flight[] newFlightsArray = new Flight[flightCode.length];
         for(int i = 0; i < flightCode.length;i++){
            Airport depart = findAirportCode(departCode[i], airports);
            Airport arrive = findAirportCode(arriveCode[i], airports);
            
            if(depart == null || arrive == null){
                return null;
            }
            newFlightsArray[i] = new Flight(flightCode[i], depart, arrive);
         }
         return newFlightsArray;
    }

    
    public static Flight findFlightCode(String code, Flight[] flights){
        for (int i = 0; i < flights.length; i++) {
            if(flights[i].getFlightCode().equalsIgnoreCase(code)){
                return flights[i];
            }
        }return null;
    }


    public static Passenger findPassenger(String name, Passenger[] passengers, int size) {
        for (int i = 0; i < size; i++) {
            if (passengers[i] != null && passengers[i].matchesName(name)) {
            return passengers[i];
            }
        }return null;
    }


    public static int addPassenger(Passenger passenger, Passenger[] passengers, int size){
        if(size >= passengers.length){
            return size;
        }
        String newName = passenger.getName();
        for (int i = 0; i < size; i++) {
        if (passengers[i] != null && passengers[i].matchesName(newName)) {
            return size;
           }
        }
        passengers[size] = passenger;
        return size + 1;
    }
    

    public static void printPassengerNames(Passenger[] passengers, int size){
        for (int i = 0; i < size; i++) {
            System.out.println(passengers[i].getName());
        }
    }
    public static void main(String[] args) {
        
    }
}
