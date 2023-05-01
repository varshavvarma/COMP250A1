package assignment1;

public class Airport {
    private int xCoord;
    private int yCoord;
    private int fees;

    public Airport(int xCoord, int yCoord, int fees) {
        this.xCoord = xCoord;
        this.yCoord = yCoord;
        this.fees = fees;
    }

    public int getFees() {
        return this.fees;
    }

    public static int getDistance(Airport a1, Airport a2) {
        int xDisp = Math.abs(a1.xCoord - a2.xCoord);
        int yDisp = Math.abs(a1.yCoord - a2.yCoord);
        int distance = (int) Math.ceil(Math.sqrt((xDisp*xDisp) + (yDisp*yDisp)));
        return distance;
    }

}
