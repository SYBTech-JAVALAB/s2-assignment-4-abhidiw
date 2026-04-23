package Assignments;

abstract class BankAccount {
    double balance;

    BankAccount(double balance) {
        this.balance = balance;
    }

    abstract void deposit(double amount);
    abstract void withdraw(double amount);

    void displayBalance() {
        System.out.println("Current Balance: " + balance);
    }
}

class SavingsAccount extends BankAccount {

    SavingsAccount(double balance) {
        super(balance);
    }

    void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount);
    }

    void withdraw(double amount) {
        if (balance - amount >= 1000) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Withdrawal denied! Minimum balance of 1000 must be maintained.");
        }
    }
}
class CurrentAccount extends BankAccount {

    CurrentAccount(double balance) {
        super(balance);
    }

    void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount);
    }

    void withdraw(double amount) {
        if (balance - amount >= -5000) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Overdraft limit exceeded!");
        }
    }
}

public class Assignment4 {
	public static void main(String[] args) {

        System.out.println("========Savings Account Transactions=======");
        SavingsAccount sa = new SavingsAccount(5000);
        sa.deposit(2000);
        sa.withdraw(4500);
        sa.withdraw(2000);
        sa.displayBalance();

        System.out.println("\n=========Current Account Transactions=========");
        CurrentAccount ca = new CurrentAccount(3000);
        ca.deposit(2000);
        ca.withdraw(8000);
        ca.withdraw(3000);
        ca.displayBalance();
    }
}
