import java.text.NumberFormat;

public class Money {

    private double amount = 0;
    public String currency = "$";

    public Money(double amount){
        this.amount = amount;
    }

    public void setAmount(double amount){
        this.amount = amount;
    }

    public double getAmount(){
        return this.amount;
    }

    public String toString(){
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        return formatter.format(this.amount);
    }

    private static double rate = 0.7665;

    public static double dollarsToEuros(double dollars){
        return dollars * rate;
    }

    public static double eurosToDollars(double euros){
        return euros / rate;
    }
}
