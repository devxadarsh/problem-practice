package problem3;

public class BankAccount {

    private double balance;

    // Constructor
    public BankAccount(double balance) {
        this.balance = balance;
    }

    // Synchronized deposit method
    public synchronized void deposit(double amount) {
        if(amount > 0) {
            balance += amount;
            System.out.println(Thread.currentThread().getName() + " deposited: Rs." + amount);
        }
    }

    // Synchronized withdrawal method
    public synchronized void withdrawal(double amount) {
        if (balance > 0 && balance-amount >= 0) {
            balance -= amount;
            System.out.println(Thread.currentThread().getName() + " Debited: Rs." + amount + ", New balance is: Rs." + balance);
        } else if (balance < amount) {
            System.out.println(Thread.currentThread().getName() + " tried to withdraw Rs." + amount + ", but insufficient balance");

        }
    }

    public double getBalance() {
        return balance;
    }
}
