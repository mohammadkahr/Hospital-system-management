package com.company;

import Date.DateCheck;
import Date.DateGuard;
import Date.DateToday;

import java.util.ArrayList;
import java.util.Scanner;

public class Guard extends Employe {
    static Scanner input = new Scanner(System.in);

//    private ArrayList<DateCheck> checkIn = new ArrayList<>();
//    private ArrayList<DateCheck> checkOut = new ArrayList<>();

    static ArrayList<Guard> guards = new ArrayList<>();

    public Guard(String name, int id, String password, String phoneNumber, String email, int workHoPerM, int presentDays, int workHoPerD, int hourlySalary, int weeklyAbsences) {
        super(name, id, password, phoneNumber, email, workHoPerM, presentDays, workHoPerD, hourlySalary, weeklyAbsences);
    }

    //setters and getters
//    public ArrayList<DateCheck> getCheckIn() {
//        return checkIn;
//    }
//    public void setCheckIn(ArrayList<DateCheck> checkIn) {
//        this.checkIn = checkIn;
//    }
//    public ArrayList<DateCheck> getCheckOut() {
//        return checkOut;
//    }
//    public void setCheckOut(ArrayList<DateCheck> checkOut) {
//        this.checkOut = checkOut;
//    }


    static void addGuard() {
        System.out.println("Enter name : ");
        System.out.println("Enter password");
        System.out.println("Enter phone number");
        System.out.println("Enter e-mail");
        System.out.println("Enter working hours (per day)");
        System.out.println("Enter hourly salary");
        int id = Guard.guards.size() + 4000;

        Guard guard = new Guard(input.next(), id, input.next(), input.next(), input.next(), 0, 30, input.nextInt(), input.nextInt(), 0);
        //guard.setWorkHoPerM(30* guard.getWorkHoPerD());

        int temp = guard.getWorkHoPerD();
        temp = temp * 60;
        guard.setWorkHoPerD(temp);

        System.out.println("Your id is : " + id);
        addGuardToArray(guard);
        System.out.println("Registered");
    }

    static void addGuardToArray(Guard guard) {
        Guard.guards.add(guard);
    }

    static void panel(int id) {
        System.out.println("Choose a number : ");
        System.out.println("1.Check in and check out list");
        System.out.println("2.View salary");
        System.out.println("3.View daily Check in and check out list(daily)");
        System.out.println("4.Check in and check out list (yourself)");
        System.out.println("9.Back");
        short select = input.nextShort();
        if (select == 1) {
            Guard.checkInPanel(id);
        }//Check-in and check-out list
        else if (select == 2) {
            Guard.calculateSalary(id);
        }//View salary
        else if (select == 3) {
            Guard.listOfEnyeryDaily();
        }//View daily Check in and check out list(daily)
        else if (select == 4) {
            Guard.listOfEnteryForEmp(id);
        }//Check in and check out list(yourself)
        else if (select == 9) {
            Main.panel();
        }//Back
    }

    static void checkInPanel(int id) {
        while (true){
            System.out.println("Choose a number : ");
            System.out.println("1.Doctor");
            System.out.println("2.Clerk");
            System.out.println("3.Guard");
            System.out.println("4.Servant");
            System.out.println("9.Back");
            short select = input.nextShort();
            if (select == 1) {
                Guard.AddEnteryDoc();
            }//Doctor
            else if (select == 2) {
                Guard.AddEnteryCle();
            }//Clerk
            else if (select == 3) {
                Guard.AddEnteryGua();
            }//Guard
            else if (select == 4) {
                Guard.AddEnterySer();
            }//Servant
            else if (select == 9) {
                Guard.panel(id);
            }//Back
        }
    }

    static void listOfGuard() {
        System.out.println("The guards are : ");
        for (int i = 0; i < Guard.guards.size(); i++) {
            System.out.println((i + 1)+". " + Guard.guards.get(i).toString()+"\n");
        }
        System.out.println("End\n");
    }

    static void AddEnteryDoc() {
        System.out.println("Enter id : ");
        int id = input.nextInt();
        Entery enter = new Entery(id, null, null, null);
        System.out.println("entrance time : (hour , min)");
        enter.setEnter(new DateGuard(input.nextInt(), input.nextInt()));
        System.out.println("Exit time : (hour , min)");
        enter.setExit(new DateGuard(input.nextInt(), input.nextInt()));
        enter.setDate(DateToday.datetoday);
        Entery.enteries.add(enter);
        Entery.enteriesDoc.add(enter);
        int time = Entery.calculateTime(enter);
        Guard.setTimeDoc(time, id);
        Guard.calculateTimeDoc(id, time);
        System.out.println("Rigesterd\n");
    }

    static void AddEnteryCle() {
        System.out.println("Enter id : ");
        int id = input.nextInt();
        Entery enter = new Entery(id, null, null, null);
        System.out.println("entrance time : (hour , min)");
        enter.setEnter(new DateGuard(input.nextInt(), input.nextInt()));
        System.out.println("Exit time : (hour , min)");
        enter.setExit(new DateGuard(input.nextInt(), input.nextInt()));
        enter.setDate(DateToday.datetoday);//
        Entery.enteries.add(enter);
        Entery.enteriesCle.add(enter);
        int time = Entery.calculateTime(enter);
        Guard.setTimeCle(time, id);
        Guard.calculateTimeCle(id, time);
        System.out.println("Rigesterd\n");
    }

    static void AddEnteryGua() {
        System.out.println("Enter id : ");
        int id = input.nextInt();
        Entery enter = new Entery(id, null, null, null);
        System.out.println("entrance time : (hour , min)");
        enter.setEnter(new DateGuard(input.nextInt(), input.nextInt()));
        System.out.println("Exit time : (hour , min)");
        enter.setExit(new DateGuard(input.nextInt(), input.nextInt()));
        enter.setDate(DateToday.datetoday);//
        Entery.enteries.add(enter);
        Entery.enteriesGua.add(enter);
        int time = Entery.calculateTime(enter);
        Guard.setTimeGua(time, id);
        Guard.calculateTimeGua(id, time);
        System.out.println("Rigesterd\n");
    }

    static void AddEnterySer() {
        System.out.println("Enter id : ");
        int id = input.nextInt();
        Entery enter = new Entery(id, null, null, null);
        System.out.println("entrance time : (hour , min)");
        enter.setEnter(new DateGuard(input.nextInt(), input.nextInt()));
        System.out.println("Exit time : (hour , min)");
        enter.setExit(new DateGuard(input.nextInt(), input.nextInt()));
        enter.setDate(DateToday.datetoday);//
        Entery.enteries.add(enter);
        Entery.enteriesSer.add(enter);
        int time = Entery.calculateTime(enter);
        Guard.setTimeSer(time, id);
        Guard.calculateTimeSer(id, time);
        System.out.println("Rigesterd\n");
    }

    static void listOfEnteryForEmp(int id) {
        int cou = 1;
        for (int i = 0; i < Entery.enteries.size(); i++) {
            if (Entery.enteries.get(i).getId() == id) {
                System.out.println((cou) + Entery.enteries.get(i).toString());
                cou++;
            }
        }
    }

    static void listOfEnyeryDaily() {
        int cou = 1;
        for (int i = 0; i < Entery.enteries.size(); i++) {
            if (Entery.enteries.get(i).getDate().getYear() == DateToday.datetoday.getYear()) {
                if (Entery.enteries.get(i).getDate().getMount() == DateToday.datetoday.getMount()) {
                    if (Entery.enteries.get(i).getDate().getDay() == DateToday.datetoday.getDay()) {
                        System.out.println((cou) + " Id : " + Entery.enteries.get(i).getId()
                                + Entery.enteries.get(i).toString());
                        cou++;
                    }
                }
            }
        }
    }

    static void calculateTimeDoc(int id, int time) {
        for (int i = 0; i < Doctor.doctors.size(); i++) {
            if (id == Doctor.doctors.get(i).getId()) {
                if (time == Doctor.doctors.get(i).getWorkHoPerD() || time > Doctor.doctors.get(i).getWorkHoPerD()) {
                    int temp = Doctor.doctors.get(i).getPresentDays();
                    temp++;
                    Doctor.doctors.get(i).setPresentDays(temp);
                } else {
                    int temp = Doctor.doctors.get(i).getWeeklyAbsences();
                    temp++;
                    Doctor.doctors.get(i).setWeeklyAbsences(temp);
                }

            }
        }
    }

    static void calculateTimeCle(int id, int time) {
        for (int i = 0; i < Clerk.clerks.size(); i++) {
            if (id == Clerk.clerks.get(i).getId()) {
                if (time == Clerk.clerks.get(i).getWorkHoPerD() || time > Clerk.clerks.get(i).getWorkHoPerD()) {
                    int temp = Clerk.clerks.get(i).getPresentDays();
                    temp++;
                    Clerk.clerks.get(i).setPresentDays(temp);
                } else {
                    int temp = Clerk.clerks.get(i).getWeeklyAbsences();
                    temp++;
                    Clerk.clerks.get(i).setWeeklyAbsences(temp);
                }

            }
        }
    }

    static void calculateTimeSer(int id, int time) {
        for (int i = 0; i < Servant.servants.size(); i++) {
            if (id == Servant.servants.get(i).getId()) {
                if (time == Servant.servants.get(i).getWorkHoPerD() || time > Servant.servants.get(i).getWorkHoPerD()) {
                    int temp = Servant.servants.get(i).getPresentDays();
                    temp++;
                    Servant.servants.get(i).setPresentDays(temp);
                } else {
                    int temp = Servant.servants.get(i).getWeeklyAbsences();
                    temp++;
                    Servant.servants.get(i).setWeeklyAbsences(temp);
                }

            }
        }
    }

    static void calculateTimeGua(int id, int time) {
        for (int i = 0; i < Guard.guards.size(); i++) {
            if (id == Guard.guards.get(i).getId()) {
                if (time == Guard.guards.get(i).getWorkHoPerD() || time > Guard.guards.get(i).getWorkHoPerD()) {
                    int temp = Guard.guards.get(i).getPresentDays();
                    temp++;
                    Guard.guards.get(i).setPresentDays(temp);
                } else {
                    int temp = Guard.guards.get(i).getWeeklyAbsences();
                    temp++;
                    Guard.guards.get(i).setWeeklyAbsences(temp);
                }

            }
        }
    }

    static void setTimeDoc(int time, int id) {
        for (int i = 0; i < Doctor.doctors.size(); i++) {
            if (id == Doctor.doctors.get(i).getId()) {
                int temp = Doctor.doctors.get(i).getWorkHoPerM();
                temp = temp + time;
                Doctor.doctors.get(i).setWorkHoPerM(temp);
            }
        }
    }

    static void setTimeCle(int time, int id) {
        for (int i = 0; i < Clerk.clerks.size(); i++) {
            if (id == Clerk.clerks.get(i).getId()) {
                int temp = Clerk.clerks.get(i).getWorkHoPerM();
                temp = temp + time;
                Clerk.clerks.get(i).setWorkHoPerM(temp);
            }
        }
    }

    static void setTimeSer(int time, int id) {
        for (int i = 0; i < Servant.servants.size(); i++) {
            if (id == Servant.servants.get(i).getId()) {
                int temp = Servant.servants.get(i).getWorkHoPerM();
                temp = temp + time;
                Servant.servants.get(i).setWorkHoPerM(temp);
            }
        }
    }

    static void setTimeGua(int time, int id) {
        for (int i = 0; i < Guard.guards.size(); i++) {
            if (id == Guard.guards.get(i).getId()) {
                int temp = Guard.guards.get(i).getWorkHoPerM();
                temp = temp + time;
                Guard.guards.get(i).setWorkHoPerM(temp);
            }
        }
    }

    static void calculateSalary(int id) {
        for (int i = 0; i < Guard.guards.size(); i++) {
            if (id == Guard.guards.get(i).getId()) {
                int salary = ((Guard.guards.get(i).getWorkHoPerM() / 60) * Guard.guards.get(i).getHourlySalary());
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
