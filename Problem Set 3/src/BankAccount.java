/*
Question 1:
Create a class called BankAccount.  The class will have the following methods:
BankAccount(float d) : A constructor to set the initial balance.
void withdraw(float d) : Removes money from the account.
void deposit(float d) : Puts money into the account.
float getBalance() : Returns the balance
Note: You don't need to any any error checking.  Let the balance become negative.

Question 2:
Add the following the BankAccount class:
Modify withdraw so if there isn't enough money, the balance is unchanged.
Add a method bool lastWithdrawFailed() that returns true if the last call to withdraw failed.

Question 3:
Add the following features to the BankAccount class:
Add boolean isClosed() that returns true if there were three withdraw failures.
Make is so getBalance() returns zero if the account is closed.

 */
public class BankAccount {

    private float balance;

    private boolean last_status = true;

    private int failures;

    public BankAccount() {
        balance = 0;
        failures = 0;
    }

    public BankAccount(float opening) {
        balance = opening;
        failures = 0;
    }

    public void deposit(float amount) {
        balance += amount;
    }

    public void withdraw(float amount) {
        if(balance > amount) {
            balance -= amount;
            last_status = true;
        }
        else {
            last_status = false;
            failures++;
        }
    }

    public boolean isClosed(){
        return failures >= 3;
    }

    public float getBalance() {
        if(isClosed()) return 0f;
        return balance;
    }

    public boolean lastWithdrawFailed(){
        return ! last_status;
    }
}
