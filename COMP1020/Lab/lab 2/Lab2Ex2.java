public class Lab2Ex2 {
  public static void main(String[] args) {
    final int NUM_CARS = 10;
    
    Car[] cars = new Car[NUM_CARS];
  
    // use this data or your own
    // another way: start out with parallel arrays and add in a loop
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

    printCars(cars);
    printMatchingMake(cars, "Ford");
    printMatchingMake(cars, "Toyota");
    printMatchingMake(cars, "Lada");
    printYearRange(cars, 1998, 2012);
    printYearRange(cars, 2015, 2015);
    printMileage(cars, 0);
    printMileage(cars, 1);
    }
    // toString method printing cars
    public static void printCars(Car[] cars){
        for(int i=0; i<cars.length; i++){
            System.out.println(cars[i].toString());
        }
    }

    // matches make method printing matching make
    public static void printMatchingMake(Car[] cars, String argMake){
        for(int x=0; x<cars.length; x++){
            if(cars[x].matchMake(argMake)){
                System.out.println(cars[x]);
            }
        }
    }

    // prints all cars within a given range of year from the array
    public static void printYearRange(Car[] cars, int year1, int year2){
        for(int y=0; y<cars.length; y++){
            if(cars[y].getYear()>=year1  && cars[y].getYear()<=year2){
                System.out.println(cars[y]);
            }
        }
    }

    // prints quality of mileage
    public static void printMileage(Car[] cars, int choice){
        if (choice>0){
            for(int m=0; m<cars.length; m++){
                if(cars[m].getMileage()<10.0){
                    System.out.println(cars[m]);
                }
            }
        }
        else{
            for(int m=0; m<cars.length; m++){
                if(cars[m].getMileage()>=10.0){
                    System.out.println(cars[m]);
                }
            }
        }
    }
}