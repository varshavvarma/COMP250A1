package assignment1;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Customer {
    private String name;
    private int balance;
    private Basket cReservations;

    public Customer(String name, int balance) {
        this.name = name;
        this.balance = balance;
        cReservations = new Basket();
    }

    public String getName() {
        return this.name;
    }

    public int getBalance() {
        return this.balance;
    }

    public Basket getBasket() {
        return this.cReservations;
    }

    public int addFunds(int amountToAdd) {
        if (amountToAdd<0) {
            throw new IllegalArgumentException("You cannot add a negative amount to your balance.");
        }
        this.balance += amountToAdd;
        return this.balance;
    }

    public int addToBasket(Reservation r) {
        if (r.reservationName().equals(this.name)) {
            cReservations.add(r);
            return cReservations.getNumOfReservations();
        } else {
            throw new IllegalArgumentException("The name on the reservation must be the same as the customer's.");
        }
    }

    public int addToBasket(Hotel h, String roomType, int numNights, boolean breakfast) {
        if (breakfast) {
            BnBReservation b = new BnBReservation(this.name,h,roomType,numNights);
            cReservations.add(b);
        } else {
            HotelReservation hr = new HotelReservation(this.name,h,roomType,numNights);
            cReservations.add(hr);
        }
        return cReservations.getNumOfReservations();
    }

    public int addToBasket(Airport a1, Airport a2) {
        try {
            FlightReservation f = new FlightReservation(this.name,a1,a2);
            cReservations.add(f);
        } catch(IllegalArgumentException e) {
            return cReservations.getNumOfReservations();
        }
        return cReservations.getNumOfReservations();
    }

    public boolean removeFromBasket(Reservation r) {
        Reservation[] rList = cReservations.getProducts();
        for (int i=0; i< cReservations.getNumOfReservations(); i++) {
            if (rList[i].equals(r)) {
                cReservations.remove(r);
                return true;
            }
        }
        return false;
    }

    public int checkOut() {
        if (this.balance < cReservations.getTotalCost()) {
            throw new IllegalStateException("Your balance is too low to make all these reservations.");
        }
        this.balance = this.balance - cReservations.getTotalCost();
        cReservations = new Basket();
        return this.balance;
    }
}
