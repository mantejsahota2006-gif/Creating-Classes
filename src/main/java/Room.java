public class Room {
    private int numberOfBeds;
    private double price;
    private boolean occupied;
    private boolean dirty;

    public Room(int numberOfBeds, double price, boolean occupied, boolean dirty) {
        this.numberOfBeds = numberOfBeds;
        this.price = price;
        this.occupied = occupied;
        this.dirty = dirty;
    }

    // 🔹 GETTERS
    public int getNumberOfBeds() {
        return numberOfBeds;
    }

    public double getPrice() {
        return price;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public boolean isDirty() {
        return dirty;
    }

    public boolean isAvailable() {
        return !occupied && !dirty;
    }

    // 🔹 NEW METHODS
    public void checkIn() {
        if (isAvailable()) {
            occupied = true;
            dirty = true;
            System.out.println("Guest checked in successfully.");
        } else {
            System.out.println("Room is not available for check-in.");
        }
    }

    public void checkOut() {
        if (occupied) {
            occupied = false;
            dirty = true;
            System.out.println("Guest checked out. Room needs cleaning.");
        } else {
            System.out.println("No guest to check out.");
        }
    }

    public void cleanRoom() {
        if (dirty) {
            dirty = false;
            System.out.println("Room has been cleaned and is now available.");
        } else {
            System.out.println("Room is clean.");
        }
    }
}