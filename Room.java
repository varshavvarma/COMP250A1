package assignment1;

public class Room {
    private String type;
    private int price;
    private boolean availability;

    public Room(String type) {
        if (type.equalsIgnoreCase("double")) {
            this.price = 9000;
        } else if (type.equalsIgnoreCase("queen")) {
            this.price = 11000;
        } else if (type.equalsIgnoreCase("king")) {
            this.price = 15000;
        } else {
            throw new IllegalArgumentException("No room of such type can be created.");
        }
        this.type = type;
        this.availability = true;
    }

    public Room(Room r) {
        if (r.type.equalsIgnoreCase("double")) {
            this.price = 9000;
        } else if (r.type.equalsIgnoreCase("queen")) {
            this.price = 11000;
        } else if (r.type.equalsIgnoreCase("king")) {
            this.price = 15000;
        } else {
            throw new IllegalArgumentException("No room of such type can be created.");
        }
        this.type = r.type;
        this.availability = true;
    }

    public String getType() {
        return this.type;
    }

    public int getPrice() {
        return this.price;
    }

    public void changeAvailability() {
        this.availability = !this.availability;
    }

    public static Room findAvailableRoom(Room[] rooms, String type) {
        for (int i = 0; i<rooms.length; i++) {
            if (rooms[i].availability && rooms[i].type.equalsIgnoreCase(type))
                return rooms[i];
        }
        return null;
    }

    public static boolean makeRoomAvailable(Room[] rooms, String type) {
        for (int i = 0; i<rooms.length; i++) {
            if(!rooms[i].availability && rooms[i].type.equalsIgnoreCase(type)) {
                rooms[i].availability = true;
                return true;
            }
        }
        return false;
    }

}
