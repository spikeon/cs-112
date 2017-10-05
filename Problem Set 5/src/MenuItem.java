import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.NumberFormat;

/*
 Write a class which represents an item on a restaurant menu.
 Call this class MenuItem.

 The class will have the following data and operations:
 - A private String variable called name which represents the name of a product
 - A private double variable called price which represents the price of a product
 - A constructor to set both the name and price
 - A getter called getName which returns name
 - A getter called getPrice which returns price
 - A method called toString which returns a String.
   This String will return the name and price in the following format:
     name $price (where price is formatted as currency). For example, Beef $2.00
 */
public class MenuItem extends JButton {
  private String name;
  private double price;
  public MenuItem that;

  public MenuItem(String name, double price) {
    super();
    this.name = name;
    this.price = price;
    that = this;

    setText(this.toString());
    addActionListener(new ClickListener());
  }

  public MenuItem(String name, double price, String image){
    super();
    this.name = name;
    this.price = price;
    that = this;

    //setText(this.toString());
    BufferedImage buttonIcon = null;
    try {
      buttonIcon = ImageIO.read(new File("images/"+image));
    } catch (IOException e) {
      e.printStackTrace();
    }
    setIcon(new ImageIcon(buttonIcon));

    setBorderPainted(false);
    setFocusPainted(false);
    setContentAreaFilled(false);
    setBorder(BorderFactory.createEmptyBorder());
    addActionListener(new ClickListener());
  }


  private String getPriceStr(){
    NumberFormat formatter = NumberFormat.getCurrencyInstance();
    formatter.setMinimumIntegerDigits(1);
    return formatter.format(price);
  }

  public String toString() {
    return name + " " + getPriceStr();
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

  private class ClickListener implements ActionListener {

    public ClickListener(){
      super();
    }

    public void actionPerformed(ActionEvent e){
      FlameBay.receipt.addMenuItem(that);
    }
  }
}
