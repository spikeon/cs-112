public class MoneyDemo {

    public static void main(String[] args) {
        double my_cash = 10.32, euros, dollars;
        euros = Money.dollarsToEuros(my_cash);
        dollars = Money.eurosToDollars(euros);
        System.out.println("$" + my_cash);
        System.out.println("€" + euros);
        System.out.println("$" + dollars);
    }

}
