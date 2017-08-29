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

    public String toString(){
        if(month < 1 || month > 12 || day < 1 || day > 31 || year < 0) return "Invalid date";
        return getMonthName(month) + " " + day + ", " + year;
    }

    public boolean comesBefore(Object other){
        if(!(other instanceof Date)) return false;
        
    }

}
