package com.pluralsight;

import java.time.LocalDateTime;

public class Employee {

    private int employeeId;
    private String name;
    private String department;
    private double payRate;
    private float hoursWorked;

    public Employee(int employeeId, String name, String department, double payRate) {
        this.employeeId = employeeId;
        this.name = name;
        this.department = department;
        this.payRate = payRate;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getPayRate() {
        return payRate;
    }

    public void setPayRate(double payRate) {
        this.payRate = payRate;
    }

    public float getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(float hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public double getTotalPay(){
        return (getRegularHours() * payRate) + (getOvertimeHours() * payRate * 1.5);
    }

    public float getRegularHours(){
        if(hoursWorked > 40){
            return 40;
        }
        else{
            return hoursWorked;
        }
    }

    public float getOvertimeHours(){
//        if(hoursWorked > 40){
//            return hoursWorked - 40;
//        }
//        else{
//            return 0;
//        }
        return (hoursWorked > 40) ? hoursWorked - 40 : 0;
    }

    private double punchInTime;

    public void punchIn(double time){
        this.punchInTime = time;
    }

    public void punchIn(){
        LocalDateTime dt = LocalDateTime.now();
        double hours = dt.getHour();
        double fractionOfHour = dt.getMinute() / 60f;
        this.punchInTime = (hours + fractionOfHour);
        //System.out.println("punch in time :" + this.punchInTime);

    }

    public void punchOut(double punchOutTime){
       // System.out.println("punch out time :" + punchOutTime);
        this.hoursWorked +=  (punchOutTime - this.punchInTime);

    }

    public void punchOut(){
        LocalDateTime dt = LocalDateTime.now();
        double hours = dt.getHour();
        double minutes = dt.getMinute();
        //System.out.println("minutes" + minutes);
        double fractionOfHour = dt.getMinute() / 60f;
        double punchOutTime = hours + fractionOfHour;
        //System.out.println("punch out time :" + punchOutTime);

        this.hoursWorked += (punchOutTime - this.punchInTime);
    }

}
