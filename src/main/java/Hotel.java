public class Hotel {
    private String name;
    private int numberOfSuites;
    private int numberOfRooms;
    private int bookedSuites;
    private int bookedBasicRooms;


    public Hotel(String name, int numberOfSuites, int numberOfRooms) {
        this.name = name;
        this.numberOfSuites = numberOfSuites;
        this.numberOfRooms = numberOfRooms;
        this.bookedSuites = 0;
        this.bookedBasicRooms = 0;
    }


    public Hotel(String name, int numberOfSuites, int numberOfRooms, int bookedSuites, int bookedBasicRooms) {
        this.name = name;
        this.numberOfSuites = numberOfSuites;
        this.numberOfRooms = numberOfRooms;
        this.bookedSuites = bookedSuites;
        this.bookedBasicRooms = bookedBasicRooms;
    }


    public String getName() { return name; }
    public int getNumberOfSuites() { return numberOfSuites; }
    public int getNumberOfRooms() { return numberOfRooms; }
    public int getBookedSuites() { return bookedSuites; }
    public int getBookedBasicRooms() { return bookedBasicRooms; }

    public int getAvailableSuites() {
        return numberOfSuites - bookedSuites;
    }

    public int getAvailableRooms() {
        return numberOfRooms - bookedBasicRooms;
    }

    public boolean bookRoom(int numberOfRoomsToBook, boolean isSuite) {
        if (isSuite) {
            if (numberOfRoomsToBook <= getAvailableSuites()) {
                bookedSuites += numberOfRoomsToBook;
                System.out.println(numberOfRoomsToBook + " suite(s) successfully booked.");
                return true;
            } else {
                System.out.println("Not enough suites available.");
                return false;
            }
        } else {
            if (numberOfRoomsToBook <= getAvailableRooms()) {
                bookedBasicRooms += numberOfRoomsToBook;
                System.out.println(numberOfRoomsToBook + " basic room(s) successfully booked.");
                return true;
            } else {
                System.out.println("Not enough basic rooms available.");
                return false;
            }
        }
    }
}