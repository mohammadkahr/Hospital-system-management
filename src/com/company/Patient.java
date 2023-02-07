package com.company;

import Date.DateToday;
import Date.DateTurn;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Patient extends User {
    static Scanner input = new Scanner(System.in);
    private ArrayList<Recipe> recipes = new ArrayList<>();

    public Patient(String name, int id, String password, String phoneNumber, String email) {
        super(name, id, password, phoneNumber, email);
    }

    static ArrayList<Patient> patients = new ArrayList<>();

    //setters and getters
    public static Scanner getInput() {
        return input;
    }

    public static void setInput(Scanner input) {
        Patient.input = input;
    }

    public ArrayList<Recipe> getRecipes() {
        return recipes;
    }

    public void setRecipes(ArrayList<Recipe> recipes) {
        this.recipes = recipes;
    }

    public static ArrayList<Patient> getPatients() {
        return patients;
    }

    public static void setPatients(ArrayList<Patient> patients) {
        Patient.patients = patients;
    }


    //Methods
    static void panel(int id) {
        short select;
        while (true) {
            System.out.println("Hello dear patient \nWhat do you want to do?");
            System.out.println("1.Edit profile\n2.list of doctors\n3.Search doctors");
            System.out.println("4.List of expertise\n5.Get turn\n6.List of turns");
            System.out.println("7.History\n8.Income estimates\n9.back");
            select = input.nextShort();
            if (select == 1) {
                editProfile(id);
            }//Edit profile
            else if (select == 2) {
                listDocForPat();
            }//list of doctors
            else if (select == 3) {
                searchDoctor();
            }//Search doctor
            else if (select == 4) {
                listOfExpertise();
            }//List of expertise
            else if (select == 5) {
                getTurn(id);
            }//Get turn
            else if (select == 6) {
                Patient.listOfTurns(id);
            }//List of turns
            else if (select == 7) {
                Patient.history(id);
            }//History
            else if (select == 8) {
                Patient.incomeEstimates();
            }//Income estimates
            else if (select == 9) {
                Main.panel();
            }//back
        }
    }

    static void addPatient() {
        System.out.println("1.enter name : ");
        System.out.println("2.enter password :");
        System.out.println("3.enter phone number : ");
        System.out.println("4.enter e-mail");
        int id = patients.size() + 10000;

        Patient patient = new Patient(input.next(), id, input.next(), input.next(), input.next());

        addPatientToArray(patient);
        System.out.println("your id is : " + id);
        System.out.println("Registered\n");
    }

    static void addPatientToArray(Patient patient) {
        Patient.patients.add(patient);
    }

    static void editProfile(int id) {
        System.out.println("Your id is : " + id);
        int i = 0;
        for (; i < Patient.patients.size(); i++) {
            if (id == Patient.patients.get(i).getId())
                break;
        }
        System.out.println("enter new name : ");
        Patient.patients.get(i).setName(input.next());
        System.out.println("enter new password : ");
        Patient.patients.get(i).setPassword(input.next());
        System.out.println("enter new phone number : ");
        Patient.patients.get(i).setPhoneNumber(input.next());
        System.out.println("enter new e-mail");
        Patient.patients.get(i).setEmail(input.next());
        System.out.println("registered\n");
    }

    static void listDocForPat() {
        if (Doctor.doctors == null) {
            System.out.println("No doctor found!");
        } else {
            for (int i = 0; i < Doctor.doctors.size(); i++) {
                System.out.println((i + 1) + "...");
                System.out.println("Name : " + Doctor.doctors.get(i).getName());
                System.out.println("Id : " + Doctor.doctors.get(i).getId());
                System.out.println("Expertise: " + Doctor.doctors.get(i).getSpecialty());
                System.out.println("Bio : " + Doctor.doctors.get(i).getBio());

            }
            System.out.println("End\n");
        }
    }

    static void searchDoctor() {
        System.out.print("Enter expertise : ");
        String expertise = input.next();
        boolean ret = false;
        for (int i = 0; i < Doctor.doctors.size() ; i++) {
            if (Objects.equals(expertise, Doctor.doctors.get(i).getSpecialty())) {
                System.out.println("Name : " + Doctor.doctors.get(i).getName());
                System.out.println("Id : " + Doctor.doctors.get(i).getId() + "\n");
                ret = true;
            }
        }
        if (!ret) System.out.println("Not found");
    }

    static void listOfExpertise() {
        if (Doctor.doctors == null) {
            System.out.println("No doctor found!");
        } else {
            for (int i = 0; i < Doctor.doctors.size(); i++) {
                System.out.println((i + 1) + "...\n" + "Expertise : " + Doctor.doctors.get(i).getSpecialty());
                System.out.println("Name : " + Doctor.doctors.get(i).getName());
                System.out.println("Id : " + Doctor.doctors.get(i).getId());
                System.out.println("Bio : " + Doctor.doctors.get(i).getBio());
            }
            System.out.println("End\n");
        }
    }

    static boolean registerDoc(int drId) {

        for (int i = 0; i < Doctor.doctors.size(); i++) {
            if (Doctor.doctors.get(i).getId() == drId) {
                return true;
            }
        }
        return false;
    }

    static void getTurn(int id) {
        int idDoc;
        System.out.println("enter doctor's id : ");
        idDoc = input.nextInt();
        boolean register = registerDoc(idDoc);
        if (register) {
            while (true) {
                System.out.print("Today is : ");
                DateToday.printDate();
                System.out.println("enter date : (day  / mount / year) ");
                DateTurn date = new DateTurn(input.nextInt(), input.nextInt(), input.nextInt());
                boolean checkDate = dateTurn(date);
                if (checkDate) {
                    int number = Clerk.NumberOfTurns(idDoc, date);
                    if (number < 10) {
                        System.out.println("Emergency?\n1.Yes\n2.no");
                        short emergency = input.nextShort();
                        boolean emer;
                        if (emergency == 1) {
                            emer = true;
                        } else emer = false;
                        Turn turn = new Turn(id, number, date, idDoc, emer);
//                        Recipe recipe = new Recipe(idDoc,id,date,number);
//                        addTurnToPai(id , recipe);
                        addTurnToDoc(idDoc, turn);
                        addTurnToTurns(turn);
                        System.out.println("Registered");
                        System.out.println("Your number is : " + (number+1));
                        panel(id);
                    } else {
                        System.out.println("You can't get turn this date!\nWhat do you want to do?");
                        System.out.println("1.Get turn again");
                        System.out.println("2.back");
                        short select = input.nextShort();
                        if (select == 1) {
                            getTurn(id);
                        } else {
                            Patient.panel(id);
                        }
                    }
                } else {
                    System.out.println("You can't get turn this date!\nWhat do you want to do?");
                    System.out.println("1.Get turn again");
                    System.out.println("2.back");
                    short select = input.nextShort();
                    if (select == 1) {
                        getTurn(id);
                    } else {
                        Patient.panel(id);
                    }
                }
            }
        } else {
            System.out.println("Not found!");
        }
    }

    //    static void addTurnToPai(int id , Recipe recipe){
//        for (int i = 0; i < Patient.patients.size(); i++) {
//            if (id == Patient.patients.get(i).getId()){
//                Patient.patients.get(i).getRecipes().add(recipe);
//            }
//        }
//    }
    static void addTurnToDoc(int idDoc, Turn turn) {
        for (int i = 0; i < Doctor.doctors.size(); i++) {
            if (idDoc == Doctor.doctors.get(i).getId()) {
                Doctor.doctors.get(i).getTurns().add(turn);
            }
        }
    }

    static void addTurnToTurns(Turn turn) {
        Turn.turns.add(turn);
    }

    static boolean dateTurn(DateTurn date) {
        if (date.getYear() >= DateToday.datetoday.getYear()) {
            if (date.getMount() >= DateToday.datetoday.getMount()) {
                if (date.getDay() >= DateToday.datetoday.getDay()) {
                    return true;
                }
            }
        }
        return false;
    }

    static void history(int id) {
        for (int i = 0; i < Patient.patients.size(); i++) {
            if (id == Patient.patients.get(i).getId()) {
                if (Patient.patients.get(i).getRecipes() != null) {
                    for (int j = 0; j < Patient.patients.get(i).getRecipes().size(); j++) {
                        System.out.println((j + 1) + "...\nDoctor's Id : " + Patient.patients.get(i).getRecipes().get(j).getDrId());
                        System.out.print("Date : " + Patient.patients.get(i).getRecipes().get(j).getVisit().getYear());
                        System.out.print(" / " + Patient.patients.get(i).getRecipes().get(j).getVisit().getMount());
                        System.out.println(" / " + Patient.patients.get(i).getRecipes().get(j).getVisit().getDay());
                        System.out.println("Number : " + Patient.patients.get(i).getRecipes().get(j).getNumber());
                        //System.out.println("Drugs : \n" + Patient.patients.get(i).getRecipes().get(j).getDrugs().toString() + "\n");
                        System.out.println("Drugs : ");
                        for (int k = 0; k < Patient.patients.get(i).getRecipes().get(j).getDrugs().size(); k++) {
                            System.out.println((k + 1) + ". Name : " + Patient.patients.get(i).getRecipes().get(j).getDrugs().get(k).getName());
                            System.out.println("Value : " + Patient.patients.get(i).getRecipes().get(j).getDrugs().get(k).getValue());
                        }
                    }
                    System.out.println("End\n");
                } else {
                    System.out.println("Not found!\n");
                }
            }
        }
    }

    static void listOfTurns(int id) {
        boolean found = true;
        for (int i = 0; i < Turn.turns.size(); i++) {
            if (Turn.turns.get(i).getPatientId() == id) {
                System.out.println((i + 1) + "...\nDoctor's id : " + Turn.turns.get(i).getDrId());
                System.out.println("Number : " + (Turn.turns.get(i).getNumber() + 1));
                System.out.print("Date : " + Turn.turns.get(i).getDateVisit().getYear() + "/");
                System.out.print(Turn.turns.get(i).getDateVisit().getMount() + "/");
                System.out.println(Turn.turns.get(i).getDateVisit().getDay());
                found = false;
            }
        }
        if (found)
            System.out.println("Not found!");
    }

    static void incomeEstimates() {
        System.out.println("Member of client is 30");
        System.out.println("Visit payment is : 25$");
        System.out.println("A month has 30 days \nSo");
        System.out.println("30 $ * 30 * 30 = 2700 $ !\n");
        //mishe taghir dad
    }

}
