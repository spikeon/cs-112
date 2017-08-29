/*
Question 1:
Create a class called Date.
Make Date have a static method called getMonthName that takes an integer,
and then returns a String representation of the corresponding month's name.
The numbers 1-12 will map to January-December respectively.
If a value outside of 1-12 is passed, return "Invalid month".

Question 2:
Add two constructors to Date:
One that takes an integer month, day, and year
Another that takes a String month, and integer day and year
Add a toString method that returns the date is the following format: Month Day, Year

Question 3:
Add a method to Date called comesBefore that determines if a Date is before another Date.

Question 4:
Add a method to Date called equals that returns true if two Dates are equal.  Make this method accept a single parameter of type Object.

Question 5:
Add a method called isLeapYear that returns true if the Date's year is a leap year.
A leap year is one that is divisible by four, but not divisible by 100.
The exception is when the year is divisible by 400, in which case the Date's year is a leap year.

Question 6:
Modify toString such that it appends "is an invalid date" if the Date represented is invalid.  Valid dates have:
A month value that's in between 1 through 12
A day value between 1 and x (see below).
x is:
28 in February in a non-leap year
29 in February in a leap year
30 in September, April, June, and November
31 in all other months

 */
public class Date {
    private int month;
    private int day;
    private int year;

    private static String[] names = {"January", "February", "March", "April", "May", "June", "July","August","September","October","November","December"};

    public static String getMonthName(int month){
        month--;
        if(month < 0 || month > 11) return "Invalid month";
        else return names[month];
    }

    public Date(int month, int day, int year){
        this.month = month;
        this.day = day;
        this.year = year;
    }

    public Date(String month, int day, int year){
        this.day = day;
        this.year = year;
        int ctr = 0;
        for(String name:names){
            ctr++;
            if(month == name) this.month = ctr;
        }
    }

    private boolean isValid(){
        if(month < 1 || month > 12) return false;
        if(day < 1) return false;
        int days_in_month = 31;
        if(month == 2) {
            if (isLeapYear()) days_in_month = 29;
            else days_in_month = 28;
        }
        if(month == 9 || month == 4 || month == 6 || month == 11) days_in_month = 30;
        if(day > days_in_month) return false;
        return true;
    }

    public String toString(){
        return getMonthName(month) + " " + day + ", " + year + (isValid() ? "" : " is an invalid date.");
    }

    public int toInt(){
        return (year * 365) + (month * 31) + day;
    }

    public boolean comesBefore(Date other){
        return toInt() < other.toInt();
    }

    public boolean equals(Object other){
        if(!(other instanceof Date)) return false;
        return toInt() == ((Date) other).toInt();
    }

    public boolean isLeapYear(){
        if(year%400 == 0) return true;
        if(year%100 == 0) return false;
        if(year%4 == 0) return true;
        return false;
    }

}
