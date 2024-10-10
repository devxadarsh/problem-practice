package problem3;

public class BankSystem {

    // Create a bank account with initial balance
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount(1000);

        Runnable depositTask = () -> {
            for (int i = 0; i < 5; i++) {
                bankAccount.deposit(100);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Runnable withdrawalTask = () -> {
            for (int i = 0; i < 5; i++) {
                bankAccount.withdrawal(150);
                try{
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        // Create multiple threads for deposits and withdrawals
        Thread t1 = new Thread(depositTask, "User1-Deposit");
        Thread t2 = new Thread(withdrawalTask, "User2-Withdraw");
        Thread t3 = new Thread(depositTask, "User3-Deposit");
        Thread t4 = new Thread(withdrawalTask, "User4-Withdraw");

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final Account Balance is: Rs." + bankAccount.getBalance());

    }

}
