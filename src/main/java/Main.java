public class Main {
    public static void main(String[] args) {
        // ---- Test Room ----
        Room room1 = new Room(2, 120.00, false, false);
        System.out.println("Room available: " + room1.isAvailable());
        room1.checkIn();   // should set occupied = true, dirty = true
        room1.checkOut();  // should set occupied = false, dirty = true
        room1.cleanRoom(); // should clean the room

        // ---- Test Employee ----
        Employee emp1 = new Employee(101, "John Smith", "Housekeeping", 20.00, 0);
        emp1.punchIn(9.0);   // 9:00 am
        emp1.punchOut(17.5); // 5:30 pm
        System.out.println("Total hours worked: " + emp1.getHoursWorked());
        System.out.println("Total pay: $" + emp1.getTotalPay());
    }
}