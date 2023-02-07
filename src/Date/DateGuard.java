package Date;

public class DateGuard {
    private int hour;
    private int min;

    public DateGuard(int hour, int min) {
        this.hour = hour;
        this.min = min;
    }

    //setters and getters
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


    @Override
    public String toString() {
        return hour +
                " / " +
                min;
    }
}
