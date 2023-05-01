package assignment1;

public class Basket {
    private Reservation[] reservations;
    private int size;
    private int totalCost;

    public Basket() {
        this.reservations = new Reservation[10];
        this.size = 0;
        this.totalCost = 0;
    }

    public Reservation[] getProducts() {
        Reservation[] newReservations = new Reservation[this.reservations.length];
        for (int i=0; i<this.reservations.length; i++) {
            newReservations[i] = this.reservations[i];
        }
        return newReservations;
    }

    private void resize() {
        Reservation[] bigger = new Reservation[this.reservations.length*2];
        for (int i=0; i < this.size; i++) {
            bigger[i] = this.reservations[i];
        }
        this.reservations = bigger;
    }

    public int add(Reservation r) {
        if (this.size == this.reservations.length) {
            resize();
        }
        this.reservations[this.size] = r;
        this.totalCost += r.getCost();
        this.size++;
        return this.size;
    }

    public boolean remove(Reservation r) {
        for (int i=0; i < this.size; i++) {
            if (this.reservations[i].equals(r)) {
                for (int j=i; j < this.size; j++) {
                    this.reservations[j] = this.reservations[j+1];
                    if (j==this.size-1)
                        this.reservations[j] = null;
                }
                this.size--;
                return true;
            }
        }
        return false;
    }

    public void clear() {
        this.reservations = new Reservation[10];
        this.size = 0;
        this.totalCost = 0;
    }

    public int getNumOfReservations() {
        return this.size;
    }

    public int getTotalCost() {
        return this.totalCost;
    }
}
