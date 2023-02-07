package Date;

public class DateToday {
    private int year;
    private int mount;
    private int day;
    private int week;

    public DateToday(int year, int mount, int day, int week) {
        this.year = year;
        this.mount = mount;
        this.day = day;
        this.week = week;
    }

    public static DateToday datetoday = new DateToday(2022, 1, 1, 1);

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

    public int getWeek() {
        return week;
    }

    public void setWeek(int week) {
        this.week = week;
    }

    public static DateToday getDatetoday() {
        return datetoday;
    }

    public static void setDatetoday(DateToday datetoday) {
        DateToday.datetoday = datetoday;
    }

    //Methods
    public static void printDate() {
        System.out.println(datetoday.mount + "/" + datetoday.day + "/" + datetoday.year);
    }

    public static void nextDay() {
        datetoday.week++;
        if (datetoday.week == 7)
            datetoday.week = 0;

        if (datetoday.day < 30) {
            datetoday.day++;
        } else if (datetoday.day == 30) {
            datetoday.day = 1;
            datetoday.mount++;
            if (datetoday.mount == 13) {
                datetoday.mount = 1;
                datetoday.year++;
            }
        }
    }


    @Override
    public String toString() {
        return year +
                " / " + mount +
                "/ " + day;
    }
}
