package ch7.제어자;

public class Time {
    private int hour; // 외부에서 직접 접근 못 하게 막는다.

    public int getHour() {
        return hour;
    }
    public void setHour(int hour) {
        if (hour < 0 || hour > 23) return;
        this.hour = hour;
    }
}
