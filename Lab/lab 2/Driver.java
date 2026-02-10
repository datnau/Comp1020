public class Driver{
    private String name;
    private int yearOfBirth;
    private int expiryYear;
    private boolean requiredGlasses;

    public Driver(String name, int yearOfBirth, int expiryYear, boolean requiredGlasses){
        this.name = name;
        this.yearOfBirth = yearOfBirth;
        this.expiryYear = expiryYear;
        this.requiredGlasses = requiredGlasses;
    }

    public static void printDrivers(Driver[] drivers, Car[] cars) {
    for (int i = 0; i < drivers.length; i++) {
        System.out.println(drivers[i] + " | Cars: " + cars[i]);
    }
    }


    public int getYearOfBirth(){
        return this.yearOfBirth;
    }

    public boolean matchName(String name){
        if(this.name.equalsIgnoreCase(name)){
            return true;
        }return false;
    }

    public  boolean isExpired(int currentYear){
        if(this.expiryYear < currentYear){
            return true;
        }return false;
    }

    public  void updateExpiry(int year) {
        if (year > this.expiryYear) {
           this.expiryYear = year;
        }
    }

    public static Driver createDriver(String name, int birthYear, int expiryYear, boolean needsGlasses){
        Driver newDriver = new Driver( name,  birthYear,  expiryYear, needsGlasses);
        return newDriver;
    }

    public String toString() {
        return "Driver{name='" + name + "', yearOfBirth=" + yearOfBirth
                + ", expiryYear=" + expiryYear + ", requiredGlasses=" + requiredGlasses + "}";
    }

    public static int countExpired(Driver[] drivers, int year){
        int count = 0;
        for(int i = 0; i < drivers.length; i++){
            if(drivers[i].isExpired(year)){
                count++;
            }
        }
        return count;
    }

    public static void updateExpiry(Driver[] drivers, int expiryYear, int toYear){
        for(int i = 0; i < drivers.length; i++){
            if(drivers[i].isExpired(expiryYear)){
                drivers[i].updateExpiry(toYear);
            }
        }
    }

    public static Driver findDriver(Driver[] drivers, String name){
        for(int i = 0;i < drivers.length; i++){
            if(drivers[i].matchName(name) == true){
                return drivers[i];
            }
        }return null;
    }
    
}