public class Car{
    private String make;
    private String model;
    private int year;
    private double mileage;
    private Driver driver;
    public Car(String make, String model, int year, double mileage){
        this.make = make;
        this.model = model;
        this.year = year;
        this.mileage =mileage;
        this.driver = null;
    }
    public double getMileage(){
        return this.mileage;

    }
    public int getYear(){
        return this.year;
    }

    public boolean matchMake(String make){
        if(this.make.equalsIgnoreCase(make)){
            return true;
        }else{
            return false;
        }
    }

    public String toString(){
        if(driver == null){
            return "Car{ make= " + make + " model= " + model + " year= " + year + " mileage= " + mileage + " }\n" + "no driver";
        }

        return "Car{ make= " + make + " model= " + model + " year= " + year + " mileage= " + mileage + " }\n" + driver.toString() ;
    }

    public void setDriver(Driver driver){
        if(driver == null){
            System.out.println("Error");
        }else{
            this.driver = driver;
        }

    }

    public void removeDriver(){
        this.driver = null;
    }
    public static void printCarsForDriversWithExpiredLicenses(Car[] cars, int currentYear) {
    for (int i = 0; i < cars.length; i++) {
        Driver driver = cars[i].driver;
        if (driver != null && driver.isExpired(currentYear)) {
            System.out.println(cars[i]);
        }
    }
    }
}