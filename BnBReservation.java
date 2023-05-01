package assignment1;

public class BnBReservation extends HotelReservation{
    public BnBReservation(String name, Hotel h, String roomType, int numNights) {
        super(name,h,roomType,numNights);
    }

    public int getCost() {
        int breakfastCost = this.getNumOfNights() * 1000;
        return (int) super.getCost() + breakfastCost;
    }
}
