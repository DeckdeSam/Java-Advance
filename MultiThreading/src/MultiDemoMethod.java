class YieldDemo extends Thread
{
    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {

            System.out.println(Thread.currentThread().getName()+"..."+i);
            Thread.yield(); // if you have any other thread then run i am hold for a sec
        }
    }
}
public class MultiDemoMethod {
    public static void main(String[] args) {

        YieldDemo y1 = new YieldDemo(); // main thread and this priority is 5
        YieldDemo y2 = new YieldDemo();
        Thread t1 = Thread.currentThread();
        System.out.println(Thread.currentThread().getName()+"Name : "+Thread.currentThread().getPriority()+"Thread Priority "+Thread.currentThread().getState());
        y1.start();
        y2.start();
    }
}
