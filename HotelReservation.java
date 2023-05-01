package assignment1;

public class HotelReservation extends Reservation {
    private Hotel h;
    private String roomType;
    private int numNights;
    private int price1Night;

    public HotelReservation(String name, Hotel h, String roomType, int numNights) {
        super(name);
        this.h = h;
        this.roomType = roomType;
        this.numNights = numNights;
        Room r = new Room(this.roomType);
        this.price1Night = r.getPrice();
        h.reserveRoom(roomType);
    }

    public int getNumOfNights() {
        return this.numNights;
    }

    public int getCost() {
        return this.price1Night*this.numNights;
    }

    public boolean equals(Object o1) {
        if (o1 instanceof HotelReservation) {
            HotelReservation o2 = (HotelReservation) o1;
            if (o2.reservationName().equals(this.reservationName()) && o2.h == this.h && o2.roomType.equals(this.roomType) && o2.numNights == this.numNights && o2.getCost() == this.getCost())
                return true;
        }
        return false;
    }
}
