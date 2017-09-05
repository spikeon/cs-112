/*
  Question 1:
  Make a class called Product that represents an item you can buy.
  Make product have a constructor that saves the name of the product (string) and the price (double).

  Question 2:
  Add a toString method to the Product class.
  Make the method return a String that contains the name and price of the product

  Question 3:
  Add a buy method to the Product class.
   This method will add the Product's price to a private, static variable.
   Lastly, add a static getOrderTotal method to Product.
   Make this method return the total of the order (i.e. the static variable).

 */
public class Product {
  private String name;
  private double price;
  private static double orderTotal = 0;

  public Product(String name, double price) {
    this.name = name;
    this.price = price;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public void buy() {
    orderTotal += price;
  }

  public static double getOrderTotal() {
    return orderTotal;
  }

  public String toString() {
    return name + " costs $" + price;
  }
}
