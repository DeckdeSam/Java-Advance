class ThreadGetid extends Thread
{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().threadId()); // thread id
    }
}
class ThreadG extends Thread
{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().threadId()); // give the Thread id
    }
}

public class ThreadIdDemo {
    public static void main(String[] args) {
        System.out.println("Main class "+ThreadG.currentThread().threadId()); // main class thread id 1
        ThreadGetid threadGetid = new ThreadGetid();
        ThreadG threadG = new ThreadG();
        threadGetid.start();
        threadG.start();
    }
}
