public class Flight {
    private String flightCode;
    private Airport depart;
    private Airport arrive;

    public Flight(String flightCode, Airport depart, Airport arrive ){
        this.flightCode = flightCode;
        this.depart = depart;
        this.arrive = arrive;
    }
    public String getFlightCode(){
        return flightCode;
    }

    public Airport getDepart(){
        return this.depart;
    }
    public Airport getArrive(){
        return this.arrive;
    }

    public boolean isInternational(){
        if(depart.getAirportCountry().equalsIgnoreCase(arrive.getAirportCountry())){
            return false;
        }else{
            return true;
        }
    }
    public String toString(){
        return "Flight: flightCode='" + flightCode + "', departFrom=" + depart + ", arriveIn=" + arrive ;
    }

}
