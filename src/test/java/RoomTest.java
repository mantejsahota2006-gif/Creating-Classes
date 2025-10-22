import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RoomTest {

    @Test
    public void testCheckInMakesRoomOccupiedAndDirty() {
        Room room = new Room(2, 120.00, false, false);
        room.checkIn();
        assertTrue(room.isOccupied());
        assertTrue(room.isDirty());
    }

    @Test
    public void testCannotCheckInWhenRoomOccupied() {
        Room room = new Room(2, 120.00, true, false);
        room.checkIn();
        assertTrue(room.isOccupied());  // still occupied
        assertFalse(room.isAvailable()); // not available
    }

    @Test
    public void testCannotCheckInWhenRoomDirty() {
        Room room = new Room(2, 120.00, false, true);
        room.checkIn();
        assertFalse(room.isOccupied());
        assertTrue(room.isDirty());
    }

    @Test
    public void testCheckOutSetsRoomUnoccupiedAndDirty() {
        Room room = new Room(2, 120.00, true, false);
        room.checkOut();
        assertFalse(room.isOccupied());
        assertTrue(room.isDirty());
    }

    @Test
    public void testCleanRoomMakesRoomAvailable() {
        Room room = new Room(2, 120.00, false, true);
        room.cleanRoom();
        assertFalse(room.isDirty());
        assertTrue(room.isAvailable());
    }

    @Test
    public void testCannotCleanOccupiedRoom() {
        Room room = new Room(2, 120.00, true, true);
        room.cleanRoom();
        assertTrue(room.isDirty()); // still dirty because occupied
    }
}