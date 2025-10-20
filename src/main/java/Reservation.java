public class Reservation {
    private String roomType; // "king" or "double"
    private double pricePerNight;
    private int numberOfNights;
    private boolean weekend;

    public Reservation(String roomType, int numberOfNights, boolean weekend) {
        this.roomType = roomType;
        this.numberOfNights = numberOfNights;
        this.weekend = weekend;
        setPrice(); // sets pricePerNight automatically
    }

    private void setPrice() {
        if (roomType.equalsIgnoreCase("king")) {
            pricePerNight = 139.00;
        } else if (roomType.equalsIgnoreCase("double")) {
            pricePerNight = 124.00;
        }

        if (weekend) {
            pricePerNight *= 1.10; // 10% increase
        }
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
        setPrice();
    }

    public double getPrice() {
        return pricePerNight;
    }

    public int getNumberOfNights() {
        return numberOfNights;
    }

    public void setNumberOfNights(int numberOfNights) {
        this.numberOfNights = numberOfNights;
    }

    public boolean isWeekend() {
        return weekend;
    }

    public void setIsWeekend(boolean weekend) {
        this.weekend = weekend;
        setPrice();
    }

    // Derived getter
    public double getReservationTotal() {
        return pricePerNight * numberOfNights;
    }
}