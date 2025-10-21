package com.pluralsight;

import java.time.LocalDateTime;

public class Employee {
    private int employeeId;
    private String name;
    private String department;
    private double payRate;
    private double hoursWorked;
    private double lastPunchInTime;

    public Employee(int employeeId, String name, String department, double payRate, double hoursWorked) {
        this.employeeId = employeeId;
        this.name = name;
        this.department = department;
        this.payRate = payRate;
        this.hoursWorked = hoursWorked;
        this.lastPunchInTime = 0;
    }

    public int getEmployeeId() { return employeeId; }
    public String getName() { return name; }
    public String getDepartment() { return department; }
    public double getPayRate() { return payRate; }
    public double getHoursWorked() { return hoursWorked; }


    public double getRegularHours() { return Math.min(hoursWorked, 40); }
    public double getOvertimeHours() { return Math.max(0, hoursWorked - 40); }
    public double getTotalPay() {
        return (getRegularHours() * payRate) + (getOvertimeHours() * payRate * 1.5);
    }


    public void punchIn(double time) {
        lastPunchInTime = time;
        System.out.println(name + " manually punched in at " + time);
    }

    public void punchOut(double time) {
        if (lastPunchInTime > 0) {
            double hours = time - lastPunchInTime;
            hoursWorked += hours;
            System.out.println(name + " manually punched out at " + time + " (worked " + hours + " hours)");
            lastPunchInTime = 0;
        } else {
            System.out.println(name + " has not punched in yet.");
        }
    }


    public void punchIn() {
        LocalDateTime now = LocalDateTime.now();
        double hour = now.getHour() + (now.getMinute() / 60.0);
        lastPunchInTime = hour;
        System.out.printf("%s automatically punched in at %.2f%n", name, hour);
    }

    public void punchOut() {
        LocalDateTime now = LocalDateTime.now();
        double hour = now.getHour() + (now.getMinute() / 60.0);

        if (lastPunchInTime > 0) {
            double hours = hour - lastPunchInTime;
            hoursWorked += hours;
            System.out.printf("%s automatically punched out at %.2f (worked %.2f hours)%n", name, hour, hours);
            lastPunchInTime = 0;
        } else {
            System.out.println(name + " has not punched in yet.");
        }
    }
}