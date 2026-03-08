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

    public static void printDrivers(Driver[] drivers) {
    for (int i = 0; i < drivers.length; i++) {
        System.out.println(drivers[i]);
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

    public static  int countExpired(Driver[] drivers, int year){
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

    public static  Driver findDriver(Driver[] drivers, String name){
        for(int i = 0;i < drivers.length; i++){
            if(drivers[i].matchName(name) == true){
                return drivers[i];
            }
        }return null;
    }
    public static void main(String[] args) {
        Driver[] drivers = {
        createDriver("Alice", 2002, 2027, true),
        createDriver("Bob", 1998, 2024, false),
        createDriver("Cindy", 2005, 2025, true),
        createDriver("Brown", 2004, 2028, true)
    };
    printDrivers(drivers);
    System.out.println(countExpired(drivers, 2026));

    updateExpiry(drivers,2025,2029);
    System.out.println(countExpired(drivers, 2030 ));

    printDrivers(drivers);
    Driver d1 = findDriver(drivers, "Bob");
    System.out.println(d1);

    }


}


// Using your Driver class from the previous exercise, write the following static methods (functions):

// Driver createDriver(String name, int birthYear, int expiryYear, boolean needsGlasses) creates and returns a new Driver by calling its constructor.
// A function to print all the drivers in a filled array.
// A function int countExpired(Driver[] drivers, int year) that counts and returns the number of drivers in the array with licenses that expired (strictly) before year.
// A function void updateExpiry(Driver[] drivers, int expiryYear, int toYear) that will update the expiry date only of licenses of drivers that have expired before expiryYear to the year toYear.
// A function Driver findDriver(Driver[] drivers, String name) that will search for and return a driver with the matching name in the array drivers. Return null if there is no match.



// a matchName(String name) function that returns a boolean true only if the driver's name matches the given name using a case-insensitive equalsIgnoreCase() comparison;
// an isExpired(int currentYear) method that returns a boolean true if the license has expired before the current year, or false otherwise;
// an updateExpiry(int year) method that will change the expiry year to the given year, but only if it is greater than the license's current expiry year: the expiry year can only increase, and not decrease.