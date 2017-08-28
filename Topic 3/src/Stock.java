
public class Stock {
    private static int instance = 0;
    public String name = "";
    public Money price;

    public String getName(){
        return this.name;
    }
    public Money getPrice() {
        return this.price;
    }

    public void setName(String name){
        this.name = name;
    }
    public void setPrice(double amount){
        this.price.setAmount(amount);
    }

    public Stock(String name){
        instance++;
        this.price = new Money(0);
        this.setName(name);
    }
    public Stock(double price){
        instance++;
        this.price = new Money(price);
    }
    public Stock(String name, double price) {
        instance++;
        this.setName(name);
        this.price = new Money(price);
    }

    public String toString() {
        return this.getName() + ":\t" + this.price;
    }
}
