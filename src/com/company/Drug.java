package com.company;

import Date.DateDrug;

import java.util.ArrayList;
import java.util.Objects;

public class Drug {
    private String name;
    private int value;
    private final DateDrug manufacturing; //tolid
    private final DateDrug expiration; // engheza

    static ArrayList<Drug> drugs = new ArrayList<>();

    public Drug(String name, int value, DateDrug manufacturing, DateDrug expiration) {
        this.name = name;
        this.value = value;
        this.manufacturing = manufacturing;
        this.expiration = expiration;
    }

    // getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public DateDrug getManufacturing() {
        return manufacturing;
    }

    public DateDrug getExpiration() {
        return expiration;
    }

    //methods

}
