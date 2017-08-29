/*
Make a class called Grade.  The class will have the following members:
An double variable called percentage that will store a percentage. (e.g. 87.5.)
A constructor to set the percentage.
A getter called getPercentage to get the current value of percentage.
A method called getLetterGrade that returns "A", "B", "C" etc. based on percentage.
 */
public class Grade {
    private double percentage;
    public Grade(double percentage){
        this.percentage = percentage;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }

    public String getLetterGrade(){
        String letter;
        if(percentage >= 90) letter = "A";
        else if(percentage >= 80) letter = "B";
        else if(percentage >= 70) letter = "C";
        else if(percentage >= 60) letter = "D";
        else letter = "F";
        return letter;
    }
}
