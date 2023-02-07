package com.company;


import Date.DateTurn;

import java.util.ArrayList;

public class Turn implements Comparable {
    private int patientId;
    private int number;
    private DateTurn dateVisit;
    private int drId;
    private boolean emergency;

    static ArrayList<Turn> turns = new ArrayList<>();

    public Turn(int patientId, int number, DateTurn dateVisit, int drId, boolean emergency) {
        this.patientId = patientId;
        this.number = number;
        this.dateVisit = dateVisit;
        this.drId = drId;
        this.emergency = emergency;
    }

    // getters and setters
    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getDrId() {
        return drId;
    }

    public void setDrId(int drId) {
        this.drId = drId;
    }

    public boolean isEmergency() {
        return emergency;
    }

    public void setEmergency(boolean emergency) {
        this.emergency = emergency;
    }

    public DateTurn getDateVisit() {
        return dateVisit;
    }

    public void setDateVisit(DateTurn dateVisit) {
        this.dateVisit = dateVisit;
    }

    @Override
    public int compareTo(Object o) {
        if (this.emergency && !((Turn) (o)).emergency) {
            return 1;
        } else if (!this.emergency && ((Turn) (o)).emergency) {
            return -1;
        } else if (this.number < ((Turn) (o)).number) {
            return 1;
        }
        return -1;
    }

    @Override
    public String toString() {
        return "patientId : " + patientId +
                ", number : " + number+1 +
                ", dateVisit : " + dateVisit.toString();
    }
}
