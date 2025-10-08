class SetPri extends Thread
{
    @Override
    public void run() {
        System.out.println(""+Thread.currentThread().getPriority());
        System.out.println("------------");
        setPriority(Thread.MIN_PRIORITY); // there are three types of priority min 1  max 10 norm 5 is default
        System.out.println("Child priority "+getPriority());
    }
}

public class ThreadDemo {
    public static void main(String[] args) throws InterruptedException {
        SetPri setPri = new SetPri();
        setPri.start();
        setPri.join();
        System.out.println("Main Thread " + Thread.currentThread().getPriority());
        Thread t1 = Thread.currentThread();
        t1.setPriority(Thread.MAX_PRIORITY); // setPriority to decide ThreadSheduler which process to run or not
        System.out.println("Its Change priority TO main " + Thread.currentThread().getPriority());

    }
}
