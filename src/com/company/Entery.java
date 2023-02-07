package com.company;

import Date.DateGuard;
import Date.DateToday;

import java.util.ArrayList;

public class Entery {
    private int id;
    private DateGuard enter;
    private DateGuard exit;
    private DateToday date;

    static ArrayList<Entery> enteriesDoc = new ArrayList<>();
    static ArrayList<Entery> enteriesCle = new ArrayList<>();
    static ArrayList<Entery> enteriesSer = new ArrayList<>();
    static ArrayList<Entery> enteriesGua = new ArrayList<>();
    static ArrayList<Entery> enteries = new ArrayList<>();

    public Entery(int id, DateGuard enter, DateGuard exit, DateToday date) {
        this.id = id;
        this.enter = enter;
        this.exit = exit;
        this.date = date;
    }

    //getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public DateGuard getEnter() {
        return enter;
    }

    public void setEnter(DateGuard enter) {
        this.enter = enter;
    }

    public DateGuard getExit() {
        return exit;
    }

    public void setExit(DateGuard exit) {
        this.exit = exit;
    }

    public DateToday getDate() {
        return date;
    }

    public void setDate(DateToday date) {
        this.date = date;
    }


    //Methods
    static int calculateTime(Entery enter) {
        int hour = (enter.exit.getHour() - enter.enter.getHour());
        int min = (enter.exit.getMin() - enter.enter.getMin());

        return (hour * 60) + min;
    }


    @Override
    public String toString() {
        return "{ enter=" + enter.toString() +
                ", exit=" + exit.toString() +
                ", date=" + date.toString() +
                '}';
    }
}
