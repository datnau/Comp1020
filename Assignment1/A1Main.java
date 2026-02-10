import java.util.Scanner;

public class A1Main {
    public static final int YEAR = 2026;
 
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
    

    public static Ticket createTicket(Flight flight, int price){
        Ticket  newTicket = new Ticket(flight, price);
        return  newTicket;

    }

    public static Ticket[] createTickets(String[] flightCodes, int[] prices, Flight[] flights){
        Ticket[] newTicket = new Ticket[flightCodes.length];
        for(int i =0; i < flightCodes.length;i++){
            Flight flight = findFlightCode(flightCodes[i], flights);
            newTicket[i] = new Ticket(flight, prices[i]);
        }
        return newTicket;

    }

    public static int findAvailableDepartureTickets(Airport depart, Ticket[] in, int inSize, Ticket[] out) {
    int outSize = 0;
    for (int i = 0; i < inSize; i++) {
        if (in[i] != null && outSize < out.length) {
            if (!in[i].isPurchased()) {
                Flight f = in[i].getFlight();
                if (f != null) {
                    Airport dep = f.getDepart();
                    if (dep != null) {
                        if (dep == depart || dep.matchesCode(depart.getAirportCode())) {
                            out[outSize] = in[i];
                            outSize++;
                        }
                    }
                }
            }
        }
    }
    return outSize;
}


    public static int findAvailableArrivalTickets(Airport arrive, Ticket[] in, int inSize, Ticket[] out) {
    int outSize = 0;
    for (int i = 0; i < inSize; i++) {
        if (in[i] != null && outSize < out.length) {
            if (!in[i].isPurchased()) {
                Flight f = in[i].getFlight();
                if (f != null) {
                    Airport arr = f.getArrive();
                    if (arr != null) {
                        if (arr == arrive || arr.matchesCode(arrive.getAirportCode())) {
                            out[outSize] = in[i];
                            outSize++;
                        }
                    }
                }
            }
        }
    }
    return outSize;
}

    public static Ticket findCheapestTicket(Ticket[] in, int inSize) {
    Ticket cheapesTicket = in[0];
    for (int i = 0; i < inSize; i++) {
        if (cheapesTicket == null && in[i] != null) {
            cheapesTicket = in[i];
        }
    }
    for (int i = 1; i < inSize; i++) {
        if (in[i] != null && cheapesTicket != null) {
            if (in[i].getPrice() < cheapesTicket.getPrice()) {
                cheapesTicket = in[i];
            }
        }
    }
    return cheapesTicket;
}


    public static void printTickets(Passenger passenger, Ticket[] tickets){
        for(int i = 0; i < tickets.length;i++){
            if(tickets[i].matchesPassengerName(passenger.getName())){
                if(tickets[i].getFlight().isInternational()){
                    System.out.println("International FLight ->" + " Departure City: " + tickets[i].getDepartureCity() + " Arrival City: " + tickets[i].getArrivalCity() + " Final ticket price: " + tickets[i].getFinalPrice());
                }if(!tickets[i].getFlight().isInternational()){
                    System.out.println("Domestic FLight ->" + " Departure City: " + tickets[i].getDepartureCity() + " Arrival City: " + tickets[i].getArrivalCity() + " Final ticket price: " + tickets[i].getFinalPrice());
                }
            }
        }
    }

    public static void main(String[] args) {
    
    Airport[] airports = createAirports(A1Data.AIRPORT_CODES, A1Data.AIRPORT_CITIES, A1Data.AIRPORT_COUNTRIES, A1Data.AIRPORT_FEES);

    Flight[] flights = createFlights(A1Data.FLIGHT_CODES, A1Data.FLIGHT_DEPART_CODES, A1Data.FLIGHT_ARRIVE_CODES, airports);

    if (flights == null) {
        System.out.println("ERROR: flight setup failed.");
        System.out.println("End of processing.");
        return;
    }

    Ticket[] tickets = createTickets(A1Data.TICKET_FLIGHT_CODES, A1Data.TICKET_PRICES, flights);
    Passenger[] passengers = new Passenger[100];
    int pSize = 0;
    for (int i = 0; i < A1Data.PASSENGER_NAMES.length; i++) {
        Passenger p = createPassenger(
                A1Data.PASSENGER_NAMES[i],
                A1Data.PASSENGER_CITIZENSHIPS[i],
                A1Data.PASSENGER_YEARS[i]);
        pSize = addPassenger(p, passengers, pSize);
    }
    Scanner sc = new Scanner(System.in);
    while (true) {
        System.out.println("\nPassengers in system:");
        printPassengerNames(passengers, pSize);
        System.out.print("\nEnter passenger name (blank to quit): ");
        String name = sc.nextLine().trim();
        if (name.length() == 0) {
            System.out.println("End of processing.");
            break;
        }
        Passenger chosen = findPassenger(name, passengers, pSize);
        if (chosen == null) {
            System.out.print("Enter citizenship: ");
            String citizenship = sc.nextLine().trim();

            System.out.print("Enter year of birth: ");
            String yobStr = sc.nextLine().trim();
            int yob;
            try {
                yob = Integer.parseInt(yobStr);
            } catch (NumberFormatException e) {
                System.out.println("ERROR");
                continue; 
            }
            if (citizenship.length() == 0 || yob < YEAR - 100 || yob > YEAR) {
                System.out.println("ERROR");
                continue;
            }
            chosen = createPassenger(name, citizenship, yob);
            pSize = addPassenger(chosen, passengers, pSize);
        }
        System.out.println();
        printTickets(chosen, tickets);
        System.out.print("\nEnter departure city (blank to choose passenger again): ");
        String depCity = sc.nextLine().trim();
        if (depCity.length() == 0) {
            continue;
        }
        Airport depart = findAirportCity(depCity, airports);
        if (depart == null) {
            System.out.println("ERROR");
            continue;
        }
        Ticket[] temp1 = new Ticket[tickets.length];
        int size1 = findAvailableDepartureTickets(depart, tickets, tickets.length, temp1);
        if (size1 == 0) {
            System.out.println("ERROR");
            continue;
        }
        System.out.print("Enter arrival city: ");
        String arrCity = sc.nextLine().trim();
        if (arrCity.length() == 0) {
            continue;
        }
        Airport arrive = findAirportCity(arrCity, airports);
        if (arrive == null) {
            System.out.println("ERROR");
            continue;
        }
        Ticket[] temp2 = new Ticket[size1];
        int size2 = findAvailableArrivalTickets(arrive, temp1, size1, temp2);
        if (size2 == 0) {
            System.out.println("ERROR");
            continue;
        }
        Ticket cheapest = findCheapestTicket(temp2, size2);
        if (cheapest == null) {
            System.out.println("ERROR");
            continue;
        }
        cheapest.purchaseTicket(chosen);
        System.out.println();
        printTickets(chosen, tickets);
    }
    sc.close();
}


    
}
