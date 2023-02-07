package Date;

public class DateCheck {
    //Check-in and check-out dates
    private int year;
    private int mount;
    private int day;
    private int hour;
    private int min;
    private int week;

    public DateCheck(int year, int mount, int day, int hour, int min, int week) {
        this.year = year;
        this.mount = mount;
        this.day = day;
        this.hour = hour;
        this.min = min;
        this.week = week;
    }

    //setters and getters
    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMount() {
        return mount;
    }

    public void setMount(int mount) {
        this.mount = mount;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getWeek() {
        return week;
    }

    public void setWeek(int week) {
        this.week = week;
    }


    //Methods


}
