
public class Lab2Ex5 {
   public static Driver createDriver(String name, int birthYear, int expiryYear, boolean needsGlasses){
        Driver newDriver = new Driver( name,  birthYear,  expiryYear, needsGlasses);
        return newDriver;
    }
    public static void printDrivers(Driver[] drivers) {
    for (int i = 0; i < drivers.length; i++) {
        System.out.println(drivers[i]);
    }
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
    
  public static void main(String[] args) {
    Driver[] drivers = new Driver[4];
    
    drivers[0] = createDriver("Ada Andrey Brzezicki", 1998, 2023, false);
    drivers[1] = createDriver("Esma Tshepo Anselmetti", 2004, 2026, true);
    drivers[2] = createDriver("Abioye Rigantona O'Connor", 1986, 2027, true);
    drivers[3] = createDriver("Imani Victor Hornick", 1990, 2024, false);
    
    System.out.println("\nAll the drivers:");
    printDrivers(drivers);

    System.out.println("\nExpired licenses: " + countExpired(drivers, 2026));

    updateExpiry(drivers, 2026, 2028);

    System.out.println("\nExpired licenses after update: " + countExpired(drivers, 2026));

    System.out.println("\nAll the drivers, after update:");
    printDrivers(drivers);
    
    System.out.println("\nSearching for drivers:");
    System.out.println("Imani Victor Hornick: " + findDriver(drivers, "Imani Victor Hornick"));
    System.out.println("imani VICTOR hornick: " + findDriver(drivers, "imani VICTOR hornick"));
    if (findDriver(drivers, "Imani Victor Hornic") == null) {
      System.out.println("Can't find Imani Victor Hornic");
    }

    System.out.println("\n*** End of program. ***");
  }
}
