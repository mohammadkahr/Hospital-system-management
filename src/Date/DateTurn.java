package Date;

public class DateTurn {
    private int day;
    private int mount;
    private int year;

    public DateTurn(int day, int mount, int year) {
        this.day = day;
        this.mount = mount;
        this.year = year;
    }

    //setters and getters
    public int getDay() {
        return day;
    }
    public void setDay(int day) {
        this.day = day;
    }
    public int getMount() {
        return mount;
    }
    public void setMount(int mount) {
        this.mount = mount;
    }
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return  day +
                " / " + mount +
                " / " + year ;
    }
}
