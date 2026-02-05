
public class Ticket {
    
    private Flight flight;
    private Passenger passengerPurchased;
    private int price;

    public Ticket(Flight flight, int price){
        this.flight = flight;
        this.price = price;
        this.passengerPurchased = null;
    }

    public int getFinalPrice() {
    int base = this.price;

    if (this.passengerPurchased != null && this.passengerPurchased.isMinor(A1Main.YEAR)) {
        int discount = (this.price * 20) / 100;
        base = this.price - discount;
    }
    int arrivalFee = this.flight.getArrive().getFee();
    return base + arrivalFee;
}

    public boolean isPurchased(){
        if(passengerPurchased == null){
            return false;
        }return true;
    }

    public void purchaseTicket(Passenger passenger) {
    if (this.passengerPurchased == null) {
        this.passengerPurchased = passenger;
    }
}


    public boolean matchesPassengerName(String name) {
    if (this.passengerPurchased == null || name == null) {
        return false;
    }
    return this.passengerPurchased.getName().equalsIgnoreCase(name);
}


    public String getDepartureCity(){
        return flight.getDepart().getCity();
    }

    public String getArrivalCity(){
        return flight.getArrive().getCity();
    }

    public Flight getFlight(){
        return flight;
    }

    public int getPrice(){
        return this.price;
    }
    public String toString() {
    return "Ticket: price=" + price + ", flight=" + flight + ", passenger=" + passengerPurchased;
}

}
