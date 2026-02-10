public class Passenger {
    private  String passengerName;
    private  String citizenship;
    private  int yearOfBirth;

    public Passenger(String passengerName, String citizenship, int yearOfBirth){
        this.passengerName = passengerName;
        this.citizenship = citizenship;
        this.yearOfBirth = yearOfBirth;
    }

    public String getName(){
        return passengerName;
    }

    public boolean isMinor(int currentYear){
        int difference = currentYear - yearOfBirth;
        if(difference < 18){
            return true;
        }else{
            return false;
        }
    }

    public boolean matchesName(String name) {
    if (name == null){
        return false;
    } 
    if (passengerName.length() != name.length()){
        return false;
    } 
    if(passengerName.equalsIgnoreCase(name)){
        return true;
    }else{
        return false;
    }
    
}


    public String toString() {
        return "Passenger: name='" + passengerName + "', citizenship='" + citizenship + "',year of birth=" + yearOfBirth;
    }

}
