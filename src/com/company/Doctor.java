package com.company;

import Date.DateToday;
import Date.DateTurn;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.Scanner;

public class Doctor extends Employe {
    static Scanner input = new Scanner(System.in);

    private final String specialty;
    private String bio;
    private ArrayList<Turn> turns = new ArrayList<>();
    // id start from 1000
    static ArrayList<Doctor> doctors = new ArrayList<>();

    public Doctor(String name, int id, String password, String phoneNumber, String email, int workHoPerM, int presentDays, int workHoPerD, int hourlySalary, int weeklyAbsences, String specialty, String bio) {
        super(name, id, password, phoneNumber, email, workHoPerM, presentDays, workHoPerD, hourlySalary, weeklyAbsences);
        this.specialty = specialty;
        this.bio = bio;
    }

    //setters and getters
    public String getSpecialty() {
        return specialty;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public static Scanner getInput() {
        return input;
    }

    public static void setInput(Scanner input) {
        Doctor.input = input;
    }

    public ArrayList<Turn> getTurns() {
        return turns;
    }

    public void setTurns(ArrayList<Turn> turns) {
        this.turns = turns;
    }

    public static ArrayList<Doctor> getDoctors() {
        return doctors;
    }

    public static void setDoctors(ArrayList<Doctor> doctors) {
        Doctor.doctors = doctors;
    }

    //methods
    static void panel(int drId) {
        short select;
        while (true) {
            System.out.println("Dear Doctor \nWhat do you want to do?");
            System.out.println("1.Add clerk\n2.List of drugs\n3.visit patient");
            System.out.println("4.View salary");
            System.out.println("5.Check in and check out list");
            System.out.println("6.Daily salary");
            System.out.println("9.back");
            select = input.nextShort();
            if (select == 1) {
                addClerk(drId);
            }//Add clerk
            else if (select == 2) {
                Admin.listOfDrugs();
            }//List of drugs
            else if (select == 3) {
                Doctor.visitPatient(drId);
            }//visit patient
            else if (select == 4) {
                Doctor.calculateSalary(drId);
            }//View salary
            else if (select == 5) {
                Guard.listOfEnteryForEmp(drId);
            }//Check in and check out list
            else if (select == 6) {
                Doctor.dailySalary(drId);
            }//Daily salary
            else if (select == 9) {
                Main.panel();
            }//back
        }
    }

    static void addDoctor() {
        int id = 1000 + Doctor.doctors.size();
        System.out.println("Enter name");
        System.out.println("Enter password");
        System.out.println("Enter phone number");
        System.out.println("Enter E-mail");
        System.out.println("Enter working hours in a day ");
        System.out.println("Enter hourly salary");
        System.out.println("Enter specialty");
        System.out.println("Enter bio");

        Doctor doctor = new Doctor(input.next(), id, input.next(), input.next(), input.next(), 0, 0, input.nextInt(), input.nextInt(), 0, input.next(), input.next());
        int temp = doctor.getWorkHoPerD();
        temp = temp * 60;
        doctor.setWorkHoPerD(temp);

        addDoctorToArray(doctor);

        System.out.println("Your id is : " + id);
        System.out.println("registered\n");

    }

    static void addDoctorToArray(Doctor doctor) {
        doctors.add(doctor);
    }

    static void addClerk(int drId) {
        System.out.println("Enter name : ");
        System.out.println("Enter password");
        System.out.println("Enter phone number");
        System.out.println("Enter e-mail");
        System.out.println("Enter working hours (per day)");
        System.out.println("Enter hourly salary");
        int id = Clerk.clerks.size() + 3000;

        Clerk clerk = new Clerk(input.next(), id, input.next(), input.next(), input.next(), 0, 30, input.nextInt(), input.nextInt(), 0, drId);

        int temp = clerk.getWorkHoPerD();
        temp = temp * 60;
        clerk.setWorkHoPerD(temp);

        System.out.println("Your id is : " + id);
        addClerkToArray(clerk);
        System.out.println("Registered");

    }

    static void addClerkToArray(Clerk clerk) {
        Clerk.clerks.add(clerk);
    }

    static void visitPatient(int docId) {
        int counter = 1;
        System.out.print("Enter your clerk id :");
        int clerkId = input.nextInt();
        boolean checkClerk = Clerk.checkClerk(clerkId);
        if (checkClerk) {
            Clerk.sortDate(docId);
            for (int i = 0; i < Doctor.doctors.size(); i++) {
                if (Doctor.doctors.get(i).getId() == docId) {
                    for (int j = 0; j < Doctor.doctors.get(i).getTurns().size(); j++) {
                        if (Doctor.doctors.get(i).getTurns().get(j).getDateVisit().getYear() == DateToday.datetoday.getYear()) {
                            if (Doctor.doctors.get(i).getTurns().get(j).getDateVisit().getMount() == DateToday.datetoday.getMount()) {
                                if (Doctor.doctors.get(i).getTurns().get(j).getDateVisit().getDay() == DateToday.datetoday.getDay()) {
                                    System.out.println(counter + ".Patient id : " + Doctor.doctors.get(i).getTurns().get(j).getPatientId() + "\n");
                                    Doctor.writeRecipe(Doctor.doctors.get(i).getTurns().get(j).getPatientId(), docId, (j + 1));
                                    counter++;
                                    //Doctor.doctors.get(i).getTurns().remove(j) ;
                                }
                            }
                        }
                    }
                }
            }
        } else {
            System.out.println("Not found!/n");
            Doctor.panel(docId);
        }
    }

    static void writeRecipe(int id, int drId, int number) {
        DateTurn dateTurn = new DateTurn(DateToday.datetoday.getDay(), DateToday.datetoday.getMount(), DateToday.datetoday.getYear());
        Recipe recipe = new Recipe(drId, id, dateTurn, number);
        for (int i = 0; i < Drug.drugs.size(); i++) {
            System.out.println((i + 1) + ".\nName : " + Drug.drugs.get(i).getName());
        }
        while (true) {
            System.out.println("select a number of drug : ");
            int select = input.nextInt();
            select--;
            for (int i = 0; i < Drug.drugs.size(); i++) {
                if (i == select) {
                    recipe.getDrugs().add(Drug.drugs.get(i));
                }
            }
            System.out.println("do you want to continent?\n1.yes\n2.no");
            select = input.nextInt();
            if (select == 2) {
                break;
            }
        }
        for (int i = 0; i < Patient.patients.size(); i++) {
            if (Patient.patients.get(i).getId() == id) {
                Patient.patients.get(i).getRecipes().add(recipe);
            }
        }
    }

    static void listOfDoc() {
        for (int i = 0; i < Doctor.doctors.size(); i++) {
            System.out.println((1 + i)+". " + Doctor.doctors.get(i).toString() + "\n");
        }
        System.out.println("End\n");
    }

    static void calculateSalary(int id) {
        for (int i = 0; i < Doctor.doctors.size(); i++) {
            if (id == Doctor.doctors.get(i).getId()) {
                int salary = ((Doctor.doctors.get(i).getWorkHoPerM() / 60) * Doctor.doctors.get(i).getHourlySalary());
                System.out.println("Your salary is : " + salary + " $");
            }
        }
    }

    static void dailySalary(int id) {
        DateTurn date = new DateTurn(DateToday.datetoday.getDay(), DateToday.datetoday.getMount(),
                DateToday.datetoday.getYear());
        int number = Clerk.NumberOfTurns(id, date);
        System.out.println("Today you have " + number + " patient");
        System.out.println("You can get " + (number * 20) + "$ from the clerk");
    }

    @Override
    public String toString() {
        return "Name : " + getName() +
                "\nId : " + getId() +
                "\nPhone number : " + getPhoneNumber() +
                "\nSpecialty : " + specialty +
                "\nBio : " + bio;
    }
}
