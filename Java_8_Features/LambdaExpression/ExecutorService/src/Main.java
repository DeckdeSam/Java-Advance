public class Main {
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount();
        Runnable t1 =()->bankAccount.withdraw("Nikki",500);
        Runnable t2 =()->bankAccount.withdraw("sam",500);
        Thread t3 = new Thread(t1);
        Thread t4 = new Thread(t2);

        t3.start();
        t4.start();
    }
}
