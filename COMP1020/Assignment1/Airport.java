public class Airport{

    private String airportCode;
    private String city;
    private String country;
    private int airportFee;

    public Airport(String airportCode, String city, String country, int airportFee){
        this.airportCode = airportCode;
        this.city = city;
        this.country = country;
        this.airportFee = airportFee;
    }
    public int getFee(){
        return airportFee;
    }

    public String getAirportCountry(){
        return country;
    }

    public String getAirportCode(){
        return airportCode;
    }



    public void setFee(int newFee){
        if(newFee > this.airportFee){
            this.airportFee = newFee;

        }
        
    }

    public boolean matchesCode(String airportCode){
        if(this.airportCode.equalsIgnoreCase(airportCode)){
            return true;
        }else{
            return false;
        }
    }

    public boolean matchesCountry(String country){
        if(this.country.equalsIgnoreCase(country)){
            return true;
        }else{
            return false;
        }
    }
    
    public boolean matchesCity(String city){
        if(this.city.equalsIgnoreCase(city)){
            return true;
        }else{
            return false;
        }
    }

    public String toString(){
        return "Airport: airportCode='" + airportCode + "', city='" + city + "', country='" + country + "', fee=" + airportFee ;
    
    }
    
}