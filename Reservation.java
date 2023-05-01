package assignment1;

public abstract class Reservation {
    private String reservationName;

    public Reservation(String name) {
        this.reservationName = name;
    }

    public final String reservationName() {
        return this.reservationName;
    }

    public abstract int getCost();

    public abstract boolean equals(Object o);

}
