import java.util.Scanner;

/*
    Write a Java program that lets a user calculate his or her Body Mass Index.
    "Body mass index (BMI) is a measure of body fat based on height and weight that applies to both adult men and women."
    BMI is calculated using your height (in feet and inches) and weight (in pounds).
    The formula for BMI is

    BMI = (weight in pounds * 703) / (height in inches) ^ 2

    where is weight in pounds and h is height in inches.
    The result of the formula then is plugged into a table to determine a person's status:

    BMI	Category
    greater than 29.9	Obese
    25.0 - 29.9	Overweight
    18.5 - 24.9	Normal
    less than 18.5	Underweight

    Your program will prompt the user for their height (get feet and inches) and weight,
    then ouput their BMI (to 1 decimal place) and category. Use floating point precision.
 */
public class Question12 {
    public static void main(String[] args){
        float feet, inches, weight, bmi;
        Scanner keyboard = new Scanner(System.in);

        System.out.println("== BMI Calculator ==");
        System.out.println("Step 1: Enter height");

        System.out.println("Feet:");
        feet = keyboard.nextFloat();

        System.out.println("Inches:");
        inches = keyboard.nextFloat();

        inches = feet * 12f + inches;

        System.out.println("Step 2: Enter weight");
        System.out.println("Pounds:");
        weight = keyboard.nextFloat();

        bmi = (weight * 703) / (float) Math.pow(inches, 2);

        System.out.println("BMI: " + String.format("%.1f", bmi));

        if(bmi >= 30) System.out.println("you are obese.");
        else if(bmi >= 25) System.out.println("you are overweight.");
        else if(bmi >= 18.5) System.out.println("you are normal.");
        else System.out.println("you are underweight.");

    }

}
