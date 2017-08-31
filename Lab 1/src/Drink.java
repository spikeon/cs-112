/*
Create a class called Drink.  Make Drink have
* A constructor to set the number of ounces in the drink
* A method called sip that decreases the number of ounces by one
* A method called gulp that decreases the number of ounces by five
* A method called remainingOunces that returns the number of ounces.
* A method called refill that sets the number of ounces to whatever is was originally.
This one is a little bit tricky.
 */

public class Drink {
    private int oz = 0;
    private int size = 0;
    public Drink(int oz){
        this.oz = oz;
        this.size = oz;
    }
    public void sip() {
        this.oz -= 1;
    }
    public void gulp(){
        this.oz -= 5;
    }
    public int remainingOunces(){
        return this.oz;
    }
    public void refill(){
        this.oz = this.size;
    }

}
