package assignment1;

public class Hotel {
    private String name;
    private Room[] rooms;

    public Hotel(String name, Room[] rooms) {
        this.name = name;
        this.rooms = new Room[rooms.length];
        for(int i = 0; i<rooms.length; i++) {
            this.rooms[i] = new Room(rooms[i].getType());
        }
    }

    public int reserveRoom(String type) {
        Room r = new Room(type);
        if (r.findAvailableRoom(this.rooms,type) == null) {
            throw new IllegalArgumentException("There is no room availability of this type.");
        } else {
            r.findAvailableRoom(this.rooms,type).changeAvailability();
            return r.getPrice();
        }
    }

    public boolean cancelRoom(String type) {
        for(int i = 0; i<this.rooms.length; i++) {
            Room r = new Room(rooms[i]);
            if (r.makeRoomAvailable(this.rooms, type))
                return true;
        }
        return false;
    }
}
