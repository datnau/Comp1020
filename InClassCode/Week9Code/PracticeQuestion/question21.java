public class question21 {
    public static void main(String[] args) {
        Car car1 = new Car();
        
        System.out.println(car1.startEngine());
        car1.refuel(80);
        System.out.println(car1.startEngine());
        System.out.println(car1.getFuel());
        car1.refuel(80);
        System.out.println(car1.getFuel());


    }
    
}

class Car implements IVehicle{
    private double fuelLevel;
    private double mileage;
    public Car(){
        this.fuelLevel = 0;
        this.mileage = 0;

    }

    public boolean startEngine(){
       if(this.fuelLevel > 0){
        System.out.println("Vroom");
        return true;
       }
       return false;
        
    }

    public void refuel(double amount) {
        if (this.fuelLevel >= 100) {
            System.out.println("Fuel is full");
            return;
        }

        this.fuelLevel += amount;

        if (this.fuelLevel > 100) {
            this.fuelLevel = 100;
        }
    }


    public double getMileage(){
        return this.mileage;
    }

    public double getFuel(){
        return this.fuelLevel;
    }

}
