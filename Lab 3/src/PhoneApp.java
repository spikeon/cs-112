public class PhoneApp implements Dialer {
  private String number = "";
  public void pressKey(int key) {
    number += key;
  }

  public void clear() {
    number = "";
  }

  public String getAssociatedContact() {
    if(number.equals("9226966")) return "Allan Hancock College";
    else if(number.equals("7861000")) return "In-N-Out Burger";
    else return "Unknown";
  }

  public String toString() {
    return "Pressed keys: " + number;
  }
}
