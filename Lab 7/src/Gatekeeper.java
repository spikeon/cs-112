import java.util.*;

public class Gatekeeper {
  private static Scanner k = new Scanner(System.in);
  private static String username;
  private static String password;
  private static Map<String, User> user_map;
  private static User user;
  public static void main(String[] args)
  {
    //parse the user database
    user_map = Database.load();

    //You now have a map full of users.
    //The key is the username and the value is the user object.
    //How can you check to see if the given username/password is correct?


    System.out.println("Enter username");
    username = k.nextLine();
    if(!checkUsername()) return;

    System.out.println("Enter password");
    password = k.nextLine();
    if(!checkPassword()) return;

    System.out.println("Successfully logged in.");

    System.out.println("Welcome "+ user.first_name + " " + user.last_name);
  }

  private static boolean checkUsername(){
    if(!user_map.containsKey(username)) {
      System.out.println("That username does not exist.");
      return false;
    }
    return true;
  }
  private static boolean checkPassword(){
    if(!user_map.get(username).password.equals(password)) {
      System.out.println("Incorrect password");
      return false;
    }
    user = user_map.get(username);
    return true;
  }

}