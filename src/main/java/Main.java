public class Main {
    public static void main(String[] args) {

        // Test Room
        Room room1 = new Room(2, 120.00, false, false);
        System.out.println("Room available: " + room1.isAvailable());

        // Test Reservation
        Reservation res1 = new Reservation("king", 3, true);
        System.out.println("Reservation total: $" + res1.getReservationTotal());

        // Test Employee
        Employee emp1 = new Employee(101, "John Smith", "Housekeeping", 20.00, 45);
        System.out.println("Total Pay for " + emp1.getName() + ": $" + emp1.getTotalPay());
    }
}