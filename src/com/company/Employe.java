package com.company;

public class Employe extends User {
    private int workHoPerM; //Working hours per month calculate salary
    private int presentDays; //Present days in week
    private int workHoPerD; // Working hours per day (Mandatory)
    private int hourlySalary;
    private int weeklyAbsences;

    public Employe(String name, int id, String password, String phoneNumber, String email, int workHoPerM, int presentDays, int workHoPerD, int hourlySalary, int weeklyAbsences) {
        super(name, id, password, phoneNumber, email);
        this.workHoPerM = workHoPerM;
        this.presentDays = presentDays;
        this.workHoPerD = workHoPerD;
        this.hourlySalary = hourlySalary;
        this.weeklyAbsences = weeklyAbsences;
    }

    //setters and getters
    public int getWorkHoPerM() {
        return workHoPerM;
    }

    public void setWorkHoPerM(int workHoPerM) {
        this.workHoPerM = workHoPerM;
    }

    public int getPresentDays() {
        return presentDays;
    }

    public void setPresentDays(int presentDays) {
        this.presentDays = presentDays;
    }

    public int getWorkHoPerD() {
        return workHoPerD;
    }

    public void setWorkHoPerD(int workHoPerD) {
        this.workHoPerD = workHoPerD;
    }

    public int getHourlySalary() {
        return hourlySalary;
    }

    public void setHourlySalary(int hourlySalary) {
        this.hourlySalary = hourlySalary;
    }

    public int getWeeklyAbsences() {
        return weeklyAbsences;
    }

    public void setWeeklyAbsences(int weeklyAbsences) {
        this.weeklyAbsences = weeklyAbsences;
    }
}
