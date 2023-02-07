package com.company;

import javax.print.attribute.standard.Severity;
import java.util.ArrayList;
import java.util.Scanner;

public class Servant extends Employe {
    //id start from 2000
    static Scanner input = new Scanner(System.in);
    static ArrayList<String> equipment = new ArrayList<>();
    static ArrayList<String> failure = new ArrayList<>();
    static ArrayList<String> accepted = new ArrayList<>();
    static ArrayList<String> buy = new ArrayList<>();

    static ArrayList<Servant> servants = new ArrayList<>();

    public Servant(String name, int id, String password, String phoneNumber, String email, int workHoPerM, int presentDays, int workHoPerD, int hourlySalary, int weeklyAbsences) {
        super(name, id, password, phoneNumber, email, workHoPerM, presentDays, workHoPerD, hourlySalary, weeklyAbsences);
    }

    //Methods
    static void panel(int id) {
        while (true) {
            System.out.println("What do you want to do ?");
            System.out.println("1.Request to add equipment");//addtaj
            System.out.println("2.Request add crash ");
            System.out.println("3.List of equipment(s)");
            System.out.println("4.List of crash(es)");
            System.out.println("5.List of accepted request (equipment) ");
            System.out.println("6.View salary");
            System.out.println("7.Check in and check out list");
            System.out.println("9.Back");

            short select = input.nextShort();

            if (select == 1) {
                Servant.addTaj();
            }//add equipment
            else if (select == 2) {
                Servant.addKha();
            }//add crash
            else if (select == 3) {
                Servant.listOfEquipment();
            }//List of equipment
            else if (select == 4) {
                Servant.listOfCrashes();
            }//List of crash
            else if (select == 5) {
                Servant.listOfAccepted();
            }//accepted request
            else if (select == 6) {
                Servant.calculateSalary(id);
            }//View salary
            else if (select == 7) {
                Guard.listOfEnteryForEmp(id);
            }//Check in and check out list
            else if (select == 9) {
                Main.panel();
            }//back
        }
    }

    static void addServant() {
        int id = 2000 + servants.size();
        System.out.println("Enter name");
        System.out.println("Enter password");
        System.out.println("Enter phone number");
        System.out.println("Enter E-mail");
        System.out.println("Enter working hours (per day)");
        System.out.println("Enter hourly salary");

        Servant servant = new Servant(input.next(), id, input.next(), input.next(), input.next(), 0, 30, input.nextInt(), input.nextInt(), 0);

        int temp = servant.getWorkHoPerD();
        temp = temp * 60;
        servant.setWorkHoPerD(temp);

        addToArrSer(servant);

        System.out.println("Your id is : " + id);
        System.out.println("registered\n");
    }

    static void addToArrSer(Servant servant) {
        servants.add(servant);
    }

    static void addTaj() {
        System.out.println("name vasileyeh mored nazar ra type konid");
        String vas = input.next();
        Servant.addToListTaj(vas);
        System.out.println("Registered\n");
    }

    static void addToListTaj(String taj) {
        Servant.failure.add(taj);
    }

    static void RemoveFromListTaj(String taj) {
        for (int i = 0; i < Servant.failure.size(); i++) {
            if (Servant.failure.get(i).equals(taj)) {
                Servant.failure.remove(i);
            }
        }
    }

    static void addKha() {
        System.out.println("name ghesmat mored nazar ra type konid");
        String ghe = input.next();
        Servant.addToListKha(ghe);
        System.out.println("Registered\n");
    }

    static void addToListKha(String ghe) {
        Servant.equipment.add(ghe);
    }

    static void RemoveFromListKha(String ghe) {
        for (int i = 0; i < Servant.equipment.size(); i++) {
            if (Servant.equipment.get(i).equals(ghe)) {
                Servant.equipment.remove(i);
            }
        }
    }

    static void listOfEquipment() {
        for (int i = 0; i < Servant.failure.size(); i++) {
            System.out.println((i + 1) + "." + Servant.failure.get(i));
        }
        System.out.println("End\n");
    }

    static void listOfCrashes() {
        for (int i = 0; i < Servant.equipment.size(); i++) {
            System.out.println((i + 1) + "." + Servant.equipment.get(i));
        }
        System.out.println("End\n");
    }

    static void listOfAccepted() {
        for (int i = 0; i < Servant.accepted.size(); i++) {
            System.out.println((i + 1) + ". " + Servant.accepted.get(i));
        }
        System.out.println("End\n");
    }

    static void listOfServant() {
        System.out.println("The servants are : ");
        for (int i = 0; i < Servant.servants.size(); i++) {
            System.out.println((i + 1)+". " + Servant.servants.get(i).toString() + "\n");
        }
        System.out.println("End\n");
    }

    static void calculateSalary(int id) {
        for (int i = 0; i < Servant.servants.size(); i++) {
            if (id == Servant.servants.get(i).getId()) {
                int salary = ((Servant.servants.get(i).getWorkHoPerM() / 60) * Servant.servants.get(i).getHourlySalary());
                System.out.println("Your salary is : " + salary + " $");
            }
        }
    }

    @Override
    public String toString() {
        return "Name : " + getName() +
                "\nId : " + getId() +
                "\nPhone number : " + getPhoneNumber() +
                "\nEmail : " + getEmail();
    }
}
