package model;

public class Day {
    private final int day;

    public Day(String inputValue) {
        this.day = parseInputValueToInt(inputValue);
    }

    private int parseInputValueToInt(String inputValue) {
        return Integer.parseInt(inputValue);
    }

    public int getDay() {
        return day;
    }
}
