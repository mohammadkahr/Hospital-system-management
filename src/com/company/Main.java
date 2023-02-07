package com.company;

import java.util.Objects;
import java.util.Scanner;

import static java.lang.System.exit;

public class Main {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        // mohammad._.hr
        panel();

    }

    static void panel() {
        short select;
        while (true) {
            System.out.println("\nHello dear user.\nPlease choose a number");
            System.out.println("1.Login\n2.Patient");
            System.out.println("3.Sing up patient\n4.Admin\n9.Exit");
            select = input.nextShort();
            if (select == 1) {
                Main.panelLogin();
            }//Login
            else if (select == 2) {
                logInpatient();
            }//patient
            else if (select == 3) {
                Patient.addPatient();
            }//sing up patient
            else if (select == 4) {
                logInAdm();
            }//manager
            else if (select == 9) {
                System.out.println("Good job");
                exit(0);
            }//exit
        }
    }

    static void panelLogin() {
        while (true) {
            System.out.println("\nHello dear user.\nPlease choose a number");
            System.out.println("1.Doctor\n2.Clerk\n3.Servant");
            System.out.println("4.Guard\n5.\n9.Back");
            short select = input.nextShort();
            if (select == 1) {
                logInDoctor();
            }//Doctor
            else if (select == 2) {
                Main.logInClerk();
            }//clerk
            else if (select == 3) {
                Main.logInServant();
            }//Servant
            else if (select == 4) {
                Main.logInGuard();
            }//Guard
            else if (select == 9) {
                Main.panel();
            }//back
        }
    }

    static void logInAdm() {
        System.out.println("Log in:\nEnter your id : ");
        String username = input.next();
        System.out.println("Enter password : ");
        String password = input.next();
        boolean check = checkInAdm(username, password);
        if (check) {
            Admin.panelAdmin();
        } else {
            System.out.println("user or password is incorrect");
        }
    }

    static boolean checkInAdm(String userName, String password) {
        if (Objects.equals(userName, "Admin")) {
            if (Objects.equals(password, "Admin")) {
                return true;
            }
        }
        return false;
    }

    static void logInpatient() {
        System.out.println("Log in:\nEnter your id : ");
        int id = input.nextInt();
        System.out.println("Enter password : ");
        String password = input.next();
        boolean check = checkInPatient(id, password);
        if (check) {
            Patient.panel(id);
        } else {
            System.out.println("user or password is incorrect");
        }
    }

    static boolean checkInPatient(int id, String password) {
        for (int i = 0; i < Patient.patients.size(); i++) {
            if (Objects.equals(Patient.patients.get(i).getId(), id)) {
                if (Objects.equals(Patient.patients.get(i).getPassword(), password)) {
                    return true;
                }
            }
        }
        return false;
    }

    static void logInDoctor() {
        System.out.println("Log in:\nEnter your id : ");
        int id = input.nextInt();
        System.out.println("Enter password : ");
        String password = input.next();
        boolean check = checkInDoctor(id, password);
        if (check) {
            Doctor.panel(id);
        } else {
            System.out.println("user or password is incorrect");
        }
    }

    static boolean checkInDoctor(int id, String password) {
        for (int i = 0; i < Doctor.doctors.size(); i++) {
            if (Objects.equals(Doctor.doctors.get(i).getId(), id)) {
                if (Objects.equals(Doctor.doctors.get(i).getPassword(), password)) {
                    return true;
                }
            }
        }
        return false;
    }

    static void logInClerk() {
        System.out.println("Log in\nEnter your id : ");
        int id = input.nextInt();
        System.out.println("Enter password : ");
        String password = input.next();
        boolean check = checkInClerk(id, password);
        if (check) {
            Clerk.panel(id);
        } else {
            System.out.println("user or password is incorrect");
        }
    }

    static boolean checkInClerk(int id, String password) {
        for (int i = 0; i < Clerk.clerks.size(); i++) {
            if (Objects.equals(Clerk.clerks.get(i).getId(), id)) {
                if (Objects.equals(Clerk.clerks.get(i).getPassword(), password)) {
                    return true;
                }
            }
        }
        return false;
    }

    static void logInServant() {
        System.out.println("Log in:\nEnter your id : ");
        int id = input.nextInt();
        System.out.println("Enter password : ");
        String password = input.next();
        boolean check = checkInServant(id, password);
        if (check) {
            Servant.panel(id);
        } else {
            System.out.println("user or password is incorrect");
        }
    }

    static boolean checkInServant(int id, String password) {
        for (int i = 0; i < Servant.servants.size(); i++) {
            if (Objects.equals(Servant.servants.get(i).getId(), id)) {
                if (Objects.equals(Servant.servants.get(i).getPassword(), password)) {
                    return true;
                }
            }
        }
        return false;
    }

    static void logInGuard() {
        System.out.println("Log in:\nEnter your id : ");
        int id = input.nextInt();
        System.out.println("Enter password : ");
        String password = input.next();
        boolean check = checkInGuard(id, password);
        if (check) {
            Guard.panel(id);
        } else {
            System.out.println("user or password is incorrect");
        }
    }

    static boolean checkInGuard(int id, String password) {
        for (int i = 0; i < Guard.guards.size(); i++) {
            if (Objects.equals(Guard.guards.get(i).getId(), id)) {
                if (Objects.equals(Guard.guards.get(i).getPassword(), password)) {
                    return true;
                }
            }
        }
        return false;
    }

}

