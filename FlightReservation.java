package assignment1;

public class FlightReservation extends Reservation {
    private Airport departure;
    private Airport arrival;

    public FlightReservation(String name, Airport departure, Airport arrival) {
        super(name);
        if (departure.equals(arrival))
            throw new IllegalArgumentException("Your departure and arrival cannot be the same.");
        this.departure = departure;
        this.arrival = arrival;
    }

    public int getCost() {
        return (int) Math.ceil(((Airport.getDistance(this.departure, this.arrival) / 167.52)*124) + this.departure.getFees() + this.arrival.getFees() + 5375);
    }

    public boolean equals(Object o1) {
        if (o1 instanceof FlightReservation) {
            FlightReservation o2 = (FlightReservation) o1;
            if (o2.reservationName().equals(this.reservationName()) && o2.departure == this.departure && o2.arrival == this.arrival)
                return true;
        }
        return false;
    }
}
