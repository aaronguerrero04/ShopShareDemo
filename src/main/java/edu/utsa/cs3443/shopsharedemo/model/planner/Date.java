package main.java.edu.utsa.cs3443.shopsharedemo.model.planner;

public class Date {
    private short day;
    private short month;
    private int year;

    public Date(short day, short month, int year){
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public short getDay() {
        return day;
    }

    public void setDay(short day) {
        this.day = day;
    }

    public short getMonth() {
        return month;
    }

    public void setMonth(short month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String toString(){
        return month+"/"+day+"/"+year;
    }
}
