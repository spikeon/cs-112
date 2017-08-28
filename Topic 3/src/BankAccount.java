public class BankAccount {
    private float balance = 0;
    private static double default_fee = 5;
    private String name = "";
    private boolean good_standing = true;
    public String ssn = "";

    public BankAccount(String name){
        this.name = name;
    }

    public BankAccount(String name, float balance){
        this.name = name;
        this.balance = balance;
    }

    public float getBalance(){
        return this.balance;
    }

    public void deposit(float balance){
        // use this.balance to prevent shadowing
        this.balance += balance;
    }

    public void applyServiceFee(){
        this.balance -= default_fee;
    }

    public String toString(){
        String result = this.name + " has $" + balance;
        if(!this.good_standing) result += " (Not in good standing.)";
        return result;
    }

    public boolean equals(Object other){
        if(!(other instanceof BankAccount)) return false;

        BankAccount ba = (BankAccount)other;

        return ssn.equals(ba.ssn);
    }

}
