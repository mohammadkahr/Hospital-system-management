package com.company;

import Date.DateTurn;

import java.util.ArrayList;

public class Recipe {
    //noskhe
    private int drId;
    private int patientId;
    //private int recipeId ;//start from 25000
    private DateTurn visit;
    private int number;
    private ArrayList<Drug> drugs = new ArrayList<>();

    static ArrayList<Recipe> recipes = new ArrayList<>();

    public Recipe(int drId, int patientId, DateTurn visit, int number) {
        this.drId = drId;
        this.patientId = patientId;
        this.visit = visit;
        this.number = number;

    }

    //setters and getters
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

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public DateTurn getVisit() {
        return visit;
    }

    public void setVisit(DateTurn visit) {
        this.visit = visit;
    }

    public ArrayList<Drug> getDrugs() {
        return drugs;
    }

    public void setDrugs(ArrayList<Drug> drugs) {
        this.drugs = drugs;
    }
}
