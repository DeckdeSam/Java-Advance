class MyThread extends Thread
{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().threadId());
        System.out.println(Thread.currentThread().getName());
        System.out.println(Thread.currentThread().getPriority());
    }
}

public class MultiDemo {
    public static void main(String[] args) {

        MyThread myThread = new MyThread();
        myThread.start();  // thread start () function to create a new thread

        // main thread  and current thread
        System.out.println(Thread.currentThread().getName()); // main thread

        System.out.println(Thread.currentThread().threadId()); // thread id

        Thread thread = Thread.currentThread();
        System.out.println(Thread.currentThread().getName()); // ye main thread ka name
        thread.setName("MyThread"); // ye hai main thread ka name set

        System.out.println(Thread.currentThread().getName());

    }
}
