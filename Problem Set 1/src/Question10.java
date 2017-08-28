import java.util.Scanner;

/*
    Output a half pyramid of stars with a height determined by the user.
    If the user enters a number less than one, exit.
 */
public class Question10 {
    public static void main(String[] args){
        System.out.println("Enter block height");
        Scanner keyboard = new Scanner(System.in);
        int x = keyboard.nextInt();
        String stars = "";
        String star = "*";
        if(x >= 1) {
            for(int i = 0; i < x; i++){
                stars += star;
                System.out.println(stars);
            }
        }
        else System.out.println("Height must at least be 1.");
    }
}
