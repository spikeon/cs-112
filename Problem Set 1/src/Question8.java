/*
    Output the numbers 1-100 inclusive starting with 100 (counting down).
    Place a comma and a space after each number except the last.
    Output a new line after the last number.
 */
public class Question8 {
    public static void main(String[] args){
        String result = "";
        for(int i = 100; i > 0; i--) result += i + (i == 1 ? "" : ", ");
        System.out.println(result);
    }
}
