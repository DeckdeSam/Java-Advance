class JoinD extends Thread
{
    @Override
    public void run() {
        System.out.println("Child Class");
    }
}


public class JoinDemo {
    public static void main(String[] args) throws InterruptedException {

        System.out.println(Thread.currentThread().getName()); // main
        System.out.println(Thread.currentThread().getState()); // Main thread which state running
        JoinD joinD = new JoinD();
        joinD.start(); // internally call run method to jvm

        joinD.join(); // if you don't call Join method a output was incorrect data
//        joinD.join(1000);// there are three types of join() and join(1000) and join (Millis:1000 , nano)
//        joinD.join(1000,100);
        System.out.println("---------------");
        for (int i = 1; i <= 5; i++) {
            System.out.println("Main Thread");
        }
    }
}
