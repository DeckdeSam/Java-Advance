class SleepD extends Thread {
    @Override
    public void run() {

        try {
            for (int i = 1; i <=5; i++) {
                System.out.println("Child Thread-");
                Thread.sleep(1000);
                // sleep method just move on Thread on sleeping mood it's not go to ready state it's only sleep thread
            }
        }catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

public class SleepDemo {
    public static void main(String[] args) {

        SleepD sleepD = new SleepD();
        sleepD.start();
    }
}
