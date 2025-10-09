class mYRunnable implements Runnable
{

    @Override
    public void run() {
        System.out.println("Hii i am Runnable interface");
    }
}


public class RunnableDemo {
    public static void main(String[] args) {

        mYRunnable t1 = new mYRunnable();
        Thread thread = new Thread(t1);
        thread.start();

    }
}
