import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {
    private int balance = 1000;
    private final ReentrantLock rl = new ReentrantLock();

    public void withdraw(String threadName, int amount) {
        System.out.println(threadName + " is trying to withdraw " + amount);
        rl.lock();
        try {
            System.out.println("Acquired lock " + threadName);
            if (balance >= amount) {
                Thread.sleep(2000);
                balance -= amount;
                System.out.println("Withdrawn " + amount + " Remaining :" + balance);
            } else {
                System.out.println("Insufficient Balance");
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            rl.unlock();
        }


    }
}
