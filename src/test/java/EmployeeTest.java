import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EmployeeTest {

    @Test
    public void testPunchInAndPunchOutCalculatesHoursCorrectly() {
        Employee emp = new Employee(101, "John", "Front Desk", 20.0, 0);
        emp.punchIn(9.0);     // 9:00 am
        emp.punchOut(17.5);   // 5:30 pm
        assertEquals(8.5, emp.getHoursWorked(), 0.001); // expected 8.5 hours
    }

    @Test
    public void testMultiplePunchesAccumulateHours() {
        Employee emp = new Employee(102, "Lisa", "Housekeeping", 18.0, 0);
        emp.punchIn(8.0);
        emp.punchOut(12.0);   // 4 hours
        emp.punchIn(13.0);
        emp.punchOut(17.0);   // +4 hours
        assertEquals(8.0, emp.getHoursWorked(), 0.001);
    }

    @Test
    public void testPunchOutWithoutPunchInDoesNotChangeHours() {
        Employee emp = new Employee(103, "Mark", "Maintenance", 22.0, 0);
        emp.punchOut(17.0); // No punchIn first
        assertEquals(0.0, emp.getHoursWorked(), 0.001);
    }
}