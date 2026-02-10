public class Lab2Ex7 {
  public static void main(String[] args) {
    final int NUM_CARS = 10;
    
    Car[] cars = new Car[NUM_CARS];
    
    // or start out with parallel arrays and make a loop...
    cars[0] = new Car("Ford", "Focus", 2012, 7.2);
    cars[1] = new Car("Toyota", "RAV4", 1998, 9.5);
    cars[2] = new Car("Cadillac", "Escalade", 2000, 23.1);
    cars[3] = new Car("Ford", "Fiesta", 1997, 6.3);
    cars[4] = new Car("VW", "Golf GTI", 2015, 8.4);
    cars[5] = new Car("Ford", "F-150", 2010, 14.0);
    cars[6] = new Car("Toyota", "Corolla", 2005, 8.2);
    cars[7] = new Car("Datsun", "240Z", 1968, 15.6);
    cars[8] = new Car("Hyundai", "Pony", 1995, 10.0);
    cars[9] = new Car("Toyota", "FJ Cruiser", 2012, 13.2);
		
    Driver[] drivers = new Driver[4];
    
    drivers[0] = Driver.createDriver("Ada Andrey Brzezicki", 1998, 2023, false);
    drivers[1] = Driver.createDriver("Esma Tshepo Anselmetti", 2004, 2026, true);
    drivers[2] = Driver.createDriver("Abioye Rigantona O'Connor", 1986, 2027, true);
    drivers[3] = Driver.createDriver("Imani Victor Hornick", 1990, 2024, false);
    
    cars[0].setDriver(drivers[0]);
    cars[1].setDriver(drivers[1]);
    cars[2].setDriver(drivers[2]);
    cars[5].setDriver(drivers[2]);
    cars[6].setDriver(drivers[2]);
    cars[9].setDriver(drivers[0]);
    
    System.out.println("\nAll the cars, after assigning drivers:");
    printCars(cars);

    System.out.println("\nOnly cars whose drivers have expired licenses:");
    Car.printCarsForDriversWithExpiredLicenses(cars, 2026);

    Driver.updateExpiry(drivers, 2026, 2028);

    System.out.println("\nOnly cars whose drivers have expired licenses, after update:");
    Car.printCarsForDriversWithExpiredLicenses(cars, 2026);

    cars[0].removeDriver();
    cars[3].setDriver(drivers[3]);
    cars[6].removeDriver();
    cars[6].setDriver(drivers[1]);

    System.out.println("\nAll the cars, after changing drivers:");
    printCars(cars);

    System.out.println("\nAll the drivers, with their cars:");
    Driver.printDrivers(drivers, cars);
    
    System.out.println("\n*** End of program. ***");
  }

  public static void printCars(Car[] cars) {
    for (int i = 0; i < cars.length; i++) {
        System.out.println(cars[i]);
    }
  }
  
  

}
