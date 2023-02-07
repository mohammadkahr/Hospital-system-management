package com.company;

import Date.DateDrug;
import Date.DateToday;

import java.util.Scanner;

public class Admin {
    static Scanner input = new Scanner(System.in);

    // Methods
    static void panelAdmin() {
        short select;
        while (true) {
            System.out.println("\nWhat do you want to do?");
            System.out.println("1.Add \n2.Add drugs.\n3.Manage day(next)");
            System.out.println("4.Add or reject Request equipment\n5.View breakdowns");
            System.out.println("6.list of drugs\n7.Suspension of employees\n");
            System.out.println("9.back");
            select = input.nextShort();
            if (select == 1) {
                Admin.panelAdd();
            }//add members
            else if (select == 2) {
                Admin.addDrugs();
            }//Add drugs
            else if (select == 3) {
                System.out.print("yesterday was : ");
                DateToday.printDate();
                DateToday.nextDay();
                System.out.println("now we are in : ");
                DateToday.printDate();
            }//Manage day
            else if (select == 4) {
                Admin.reqEquipment();
            }//Add or reject Request equipment
            else if (select == 5) {
                Admin.reqFailure();
            }//View breakdowns
            else if (select == 6) {
                Admin.listOfDrugs();
            }//list of drugs
            else if (select == 7) {
                Admin.panelOfSuspension();
            }//Suspension of employees
            else if (select == 8) {

            }//
            else if (select == 9) {
                Main.panel();
            }//back
        }
    }

    static void panelAdd() {
        short select;
        while (true) {
            System.out.println("\nWhat do you want to do?");
            System.out.println("1.Add doctor\n2.Add guard\n3.Add servant");
            System.out.println("4.Add ready\n5.List of doctors");
            System.out.println("6.List of guard\n7.List of servant\n8.List of clerk");
            System.out.println("9.back");

            select = input.nextShort();

            if (select == 1) {
                Doctor.addDoctor();
            }//Add doctor
            else if (select == 2) {
                Guard.addGuard();
            }//add guard
            else if (select == 3) {
                Servant.addServant();
            }//Add servant
            else if (select == 4) {
                Admin.AddReady();
            }//add ready
            else if (select == 5) {
                Doctor.listOfDoc();
            }//List of doctors
            else if (select == 6) {
                Guard.listOfGuard();
            }//List of guard
            else if (select == 7) {
                Servant.listOfServant();
            }//list of servant
            else if (select == 8) {
                Clerk.listOfClerk();
            }//list of clerk
            else if (select == 9) {
                Admin.panelAdmin();
            }//back
        }
    }

    static void AddReady() {
        Patient.patients.add(new Patient("selen", 10001, "1234", "9134567891", "1122@gmail.com"));
        Patient.patients.add(new Patient("Shawn", 10002, "1234", "9134567892", "2233@gmail.com"));
        Patient.patients.add(new Patient("Ed", 10003, "1234", "9134567893", "3344@gmail.com"));
        Doctor.doctors.add(new Doctor("reza", 1001, "1234", "9134567894", "4455@gmail.com", 0, 0, 3, 50, 0, "ghosh", "ege:50 - .... "));
        Doctor.doctors.add(new Doctor("nima", 1002, "1234", "9134567895", "5566@gmail.com", 0, 0, 3, 50, 0, "cheshm", "ege:53 - .... "));
        Doctor.doctors.add(new Doctor("ali", 1003, "1234", "9134567896", "6677@gmail.com", 0, 0, 3, 50, 0, "asaab", "ege:55 - .... "));
        Drug.drugs.add(new Drug("morphin", 100, new DateDrug(2021, 1), new DateDrug(2023, 1)));
        Drug.drugs.add(new Drug("feshar", 150, new DateDrug(2020, 5), new DateDrug(2025, 5)));
        Clerk.clerks.add(new Clerk("adel", 3001, "1234", "9134567897", "7788@gmail.com", 0, 0, 3, 20, 0, 1001));
        Clerk.clerks.add(new Clerk("mahdi", 3002, "1234", "9134567898", "8899@gmail.com", 0, 0, 3, 20, 0, 1002));
        Clerk.clerks.add(new Clerk("hosein", 3003, "1234", "9134567899", "9900@gmail.com", 0, 0, 3, 20, 0, 1003));


        System.out.println("Registered!");
    }

    static void addDrugs() {
        int select;
        do {
            System.out.println("1.enter medicine name:");
            System.out.println("2.enter value of medicine");
            System.out.println("3.enter Date of manufacture(year - mount)");
            System.out.println("4.enter Expiration date(year - mount)");
            Drug drug = new Drug(input.next(), input.nextInt(), new DateDrug(input.nextInt(), input.nextInt()), new DateDrug(input.nextInt(), input.nextInt()));
            addDrugToArr(drug);
            System.out.println("do you want to continue?\n1.yes\n2.no");
            select = input.nextInt();
        } while (select != 2);
        System.out.println("registered\n");
    }

    static void addDrugToArr(Drug drug) {
        Drug.drugs.add(drug);
    }

    static void reqEquipment() {
        for (int i = 0; i < Servant.equipment.size(); i++) {
            System.out.println((i + 1) + "." + Servant.equipment.get(i));
            System.out.println("Select a number ");
            System.out.println("1.Accept");
            System.out.println("2.reject");
            short select = input.nextShort();
            if (select == 1) {
                Servant.accepted.add(Servant.equipment.get(i));
                Servant.RemoveFromListKha(Servant.equipment.get(i));
            } else {
                Servant.RemoveFromListKha(Servant.equipment.get(i));
            }
        }
        System.out.println("End\n");
    }

    static void reqFailure() {
        for (int i = 0; i < Servant.failure.size(); i++) {
            System.out.println((i + 1) + "." + Servant.failure.get(i));
            System.out.println("Select a number ");
            System.out.println("1.Buy");
            System.out.println("2.Reject");
            short select = input.nextShort();
            if (select == 1) {
                Servant.buy.add(Servant.failure.get(i));
                Servant.RemoveFromListTaj(Servant.failure.get(i));
            } else {
                Servant.RemoveFromListTaj(Servant.failure.get(i));
            }
        }
        System.out.println("End\n");
    }

    static void listOfDrugs() {
        for (int i = 0; i < Drug.drugs.size(); i++) {
            System.out.println((i + 1) + "...\nname : " + Drug.drugs.get(i).getName());
            System.out.println("value : " + Drug.drugs.get(i).getValue());
            System.out.println("Date of manufacture : " + Drug.drugs.get(i).getManufacturing().getYear() + "/" + Drug.drugs.get(i).getManufacturing().getMount());
            System.out.println("Expiration date : " + Drug.drugs.get(i).getExpiration().getYear() + "/" + Drug.drugs.get(i).getExpiration().getMount() + "\n");
        }
        System.out.println("End\n");
    }

    static void panelOfSuspension() {
        short select;
        while (true) {
            System.out.println("\nWhat do you want to do?");
            System.out.println("1.Doctor");
            System.out.println("2.Clerk");
            System.out.println("3.Guard\n4.Servant");
            System.out.println("9.back");
            select = input.nextShort();
            if (select == 1) {
                Admin.suspensionOfDoc();
            }//Doctor
            else if (select == 2) {
                Admin.suspensionOfCle();
            }//Clerk
            else if (select == 3) {
                Admin.suspensionOfGua();
            }//Guard
            else if (select == 4) {
                Admin.suspensionOfSer();
            }//Servant
            else if (select == 9) {
                Admin.panelAdmin();
            }//back
        }
    }

    static void suspensionOfDoc() {
        for (int i = 0; i < Doctor.doctors.size(); i++) {
            if (Doctor.doctors.get(i).getWeeklyAbsences() > 2) {
                System.out.println(Doctor.doctors.get(i).toString());
                System.out.println("Are you firing this doctor?\n1.yes\n2.no");
                short select = input.nextShort();
                if (select == 1) {
                    Doctor.doctors.remove(i);
                }
                System.out.println("choose a number \n1.continue\n2.Exit");
                select = input.nextShort();
                if (select == 2) {
                    break;
                }
            }
        }
    }

    static void suspensionOfCle() {
        for (int i = 0; i < Clerk.clerks.size(); i++) {
            if (Clerk.clerks.get(i).getWeeklyAbsences() > 2) {
                System.out.println(Clerk.clerks.get(i).toString());
                System.out.println("Are you firing this doctor?\n1.yes\n2.no");
                short select = input.nextShort();
                if (select == 1) {
                    Clerk.clerks.remove(i);
                }
                System.out.println("choose a number \n1.continue\n2.Exit");
                select = input.nextShort();
                if (select == 2) {
                    break;
                }
            }
        }
    }

    static void suspensionOfGua() {
        for (int i = 0; i < Guard.guards.size(); i++) {
            if (Guard.guards.get(i).getWeeklyAbsences() > 2) {
                System.out.println(Guard.guards.get(i).toString());
                System.out.println("Are you firing this doctor?\n1.yes\n2.no");
                short select = input.nextShort();
                if (select == 1) {
                    Guard.guards.remove(i);
                }
                System.out.println("choose a number \n1.continue\n2.Exit");
                select = input.nextShort();
                if (select == 2) {
                    break;
                }
            }
        }
    }

    static void suspensionOfSer() {
        for (int i = 0; i < Servant.servants.size(); i++) {
            if (Servant.servants.get(i).getWeeklyAbsences() > 2) {
                System.out.println(Servant.servants.get(i).toString());
                System.out.println("Are you firing this doctor?\n1.yes\n2.no");
                short select = input.nextShort();
                if (select == 1) {
                    Servant.servants.remove(i);
                }
                System.out.println("choose a number \n1.continue\n2.Exit");
                select = input.nextShort();
                if (select == 2) {
                    break;
                }
            }
        }
    }
}
