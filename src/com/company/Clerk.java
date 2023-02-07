package com.company;

import Date.DateToday;
import Date.DateTurn;

import java.util.ArrayList;
import java.util.Scanner;


public class Clerk extends Employe {
    static Scanner input = new Scanner(System.in);

    private int drID;
    private ArrayList<Turn> turnsDaily = new ArrayList<>();
    private ArrayList<Turn> turnsWeekly = new ArrayList<>();

    static ArrayList<Clerk> clerks = new ArrayList<>();

    public Clerk(String name, int id, String password, String phoneNumber, String email, int workHoPerM, int presentDays, int workHoPerD, int hourlySalary, int weeklyAbsences, int drID) {
        super(name, id, password, phoneNumber, email, workHoPerM, presentDays, workHoPerD, hourlySalary, weeklyAbsences);
        this.drID = drID;
    }

    //setters and getters
    public int getDrID() {
        return drID;
    }

    public void setDrID(int drID) {
        this.drID = drID;
    }

    public ArrayList<Turn> getTurnsDaily() {
        return turnsDaily;
    }

    public void setTurnsDaily(ArrayList<Turn> turnsDaily) {
        this.turnsDaily = turnsDaily;
    }

    public ArrayList<Turn> getTurnsWeekly() {
        return turnsWeekly;
    }

    public void setTurnsWeekly(ArrayList<Turn> turnsWeekly) {
        this.turnsWeekly = turnsWeekly;
    }

    //Methods
    static void panel(int id) {
        while (true) {
            System.out.println("\nPlease choose a number");
            System.out.println("1.List of daily visit \n2.List of weekly visit\n3.View salary");
            System.out.println("4.Check in and check out list");
            System.out.println("9.Back");
            short select = input.nextShort();
            if (select == 1) {
                Clerk.listOfDaily(id);
            }//List of daily visit
            else if (select == 2) {
                Clerk.listOfWeekly(id);
            }//List of weekly visit
            else if (select == 3) {
                Clerk.calculateSalary(id);
            }//View salary
            else if (select == 4) {
                Guard.listOfEnteryForEmp(id);
            }//Check in and check out list
            else if (select == 9) {
                Main.panel();
            }//back
        }
    }

    static void sortDate(int id) {
        for (int j = 0; j < Doctor.doctors.size(); j++) {
            if (id == Doctor.doctors.get(j).getId()) {
                for (int i = 0; i < Doctor.doctors.get(j).getTurns().size(); i++) {
                    for (int k = 0; k < Doctor.doctors.get(j).getTurns().size() - 1 - i; k++) {
                        if (Doctor.doctors.get(j).getTurns().get(k).compareTo(Doctor.doctors.get(j).getTurns().get(k + 1)) > 0) {
                            Turn turn = Doctor.doctors.get(j).getTurns().get(k);
                            Doctor.doctors.get(j).getTurns().remove(k);
                            Doctor.doctors.get(j).getTurns().add(k + 1, turn);
                        }
                    }
                }
            }
        }

//        for(int i=0; i<clerk.turnsDaily.size(); i++) {
//            for(int j=0; j<clerk.turnsDaily.size()-1-i; j++) {
//                if(clerk.turnsDaily.get(j).compareTo(clerk.turnsDaily.get(j+1)) > 0) {
//                    Turn turn = clerk.turnsDaily.get(j);
//                    clerk.turnsDaily.remove(j);
//                    clerk.turnsDaily.add(j+1,turn);
//                }
//            }
//        }
    }

    static int NumberOfTurns(int drID, DateTurn date) {
        int counter = 0;
        for (int i = 0; i < Doctor.doctors.size(); i++) {
            if (drID == Doctor.doctors.get(i).getId()) {
                for (int j = 0; j < Doctor.doctors.get(i).getTurns().size(); j++) {
                    if (date.getYear() == Doctor.doctors.get(i).getTurns().get(j).getDateVisit().getYear()) {
                        if (date.getMount() == Doctor.doctors.get(i).getTurns().get(j).getDateVisit().getMount()) {
                            if (date.getDay() == Doctor.doctors.get(i).getTurns().get(j).getDateVisit().getDay()) {
                                counter++;
                            }
                        }
                    }
                }
            }
        }
        return counter;
    }

    static boolean checkClerk(int id) {
        for (int i = 0; i < Clerk.clerks.size(); i++) {
            if (id == Clerk.clerks.get(i).getId())
                return true;
        }
        return false;
    }

    static void listOfClerk() {
        System.out.println("The clerks are : ");
        for (int i = 0; i < Clerk.clerks.size(); i++) {
            System.out.println((i + 1)+". " + Clerk.clerks.get(i).toString() + "\n");
        }
        System.out.println("End\n");
    }

    static void calculateSalary(int id) {
        for (int i = 0; i < Clerk.clerks.size(); i++) {
            if (id == Clerk.clerks.get(i).getId()) {
                int salary = ((Clerk.clerks.get(i).getWorkHoPerM() / 60) * Clerk.clerks.get(i).getHourlySalary());
                System.out.println("Your salary is : " + salary + " $");
            }
        }
    }

    static void listOfDaily(int id) {
        int counter = 1;
        for (int i = 0; i < Clerk.clerks.size(); i++) {
            if (Clerk.clerks.get(i).getId() == id) {
                for (int j = 0; j < Doctor.doctors.size(); j++) {
                    if (Doctor.doctors.get(j).getId() == Clerk.clerks.get(i).getDrID()) {
                        for (int k = 0; k < Doctor.doctors.get(j).getTurns().size(); k++) {
                            if (Doctor.doctors.get(j).getTurns().get(k).getDateVisit().getYear() == DateToday.datetoday.getYear()) {
                                if (Doctor.doctors.get(j).getTurns().get(k).getDateVisit().getMount() == DateToday.datetoday.getMount()) {
                                    if (Doctor.doctors.get(j).getTurns().get(k).getDateVisit().getDay() == DateToday.datetoday.getDay()) {
                                        System.out.println((counter) +". "+ Doctor.doctors.get(j).getTurns().get(k).toString());
                                        counter++;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    static void listOfWeekly(int id) {
        int counter = 1;
        for (int i = 0; i < Clerk.clerks.size(); i++) {
            if (Clerk.clerks.get(i).getId() == id) {
                for (int j = 0; j < Doctor.doctors.size(); j++) {
                    if (Doctor.doctors.get(j).getId() == Clerk.clerks.get(i).getDrID()) {
                        for (int k = 0; k < Doctor.doctors.get(j).getTurns().size(); k++) {
                            for (int l = 0; l < 8; l++) {
                                if (Doctor.doctors.get(j).getTurns().get(k).getDateVisit().getYear() == DateToday.datetoday.getYear()) {
                                    if (Doctor.doctors.get(j).getTurns().get(k).getDateVisit().getMount() == DateToday.datetoday.getMount()) {
                                        if (Doctor.doctors.get(j).getTurns().get(k).getDateVisit().getDay() == (DateToday.datetoday.getDay() + l)) {
                                            System.out.println((counter) +". "+ Doctor.doctors.get(j).getTurns().get(k).toString());
                                            counter++;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }


    }

    @Override
    public String toString() {
        return "Name : " + getName() +
                "\nId : " + getId() +
                "\nPhone number : " + getPhoneNumber() +
                "\nEmail : " + getEmail() +
                "\nDoctor id : " + getDrID();
    }
}