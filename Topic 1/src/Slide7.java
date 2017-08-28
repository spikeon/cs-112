import java.util.Scanner;

public class Slide7 {
    public static double findAverage(double num_list[]){
        double result = 0;
        for (int x = 0; x < num_list.length; x++){
            result += num_list[x];
        }
        result = result / num_list.length;
        return result;
    }

    public static void main(String[] args){
        Scanner keyboard = new Scanner(System.in);
        System.out.println("How many numbers do you have?");
        int count = keyboard.nextInt();
        double some_numbers[] = new double[count];
        for(int x = 0; x < some_numbers.length; x++){
            System.out.println("Enter number " + x);
            some_numbers[x] = keyboard.nextDouble();
        }
        double result = findAverage(some_numbers);
        System.out.println("Average: " + result);
    }
}
