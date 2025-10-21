public class Employee {
    private int employeeId;
    private String name;
    private String department;
    private double payRate;
    private double hoursWorked;
    private double lastPunchInTime; // 🔹 new variable

    public Employee(int employeeId, String name, String department, double payRate, double hoursWorked) {
        this.employeeId = employeeId;
        this.name = name;
        this.department = department;
        this.payRate = payRate;
        this.hoursWorked = hoursWorked;
        this.lastPunchInTime = 0;
    }

    // 🔹 BASIC GETTERS
    public int getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public double getPayRate() {
        return payRate;
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    // 🔹 DERIVED GETTERS
    public double getRegularHours() {
        return Math.min(hoursWorked, 40);
    }

    public double getOvertimeHours() {
        return Math.max(0, hoursWorked - 40);
    }

    public double getTotalPay() {
        return (getRegularHours() * payRate) + (getOvertimeHours() * payRate * 1.5);
    }

    // 🔹 NEW METHODS
    public void punchIn(double time) {
        lastPunchInTime = time;
        System.out.println(name + " punched in at " + time);
    }

    public void punchOut(double time) {
        if (lastPunchInTime > 0) {
            double hours = time - lastPunchInTime;
            hoursWorked += hours;
            System.out.println(name + " punched out at " + time + " (worked " + hours + " hours)");
            lastPunchInTime = 0; // reset after punching out
        } else {
            System.out.println(name + " has not punched in yet.");
        }
    }
}