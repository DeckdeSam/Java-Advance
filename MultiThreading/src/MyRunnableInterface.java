class Demo {
    int Add = 0;


    void sum() {
        for (int i = 1; i <= 1000; i++) {
            Add = Add + 1;
        }
    }
}

class P1 implements Runnable{
   Demo add;

    P1(Demo add)
    {
        this.add=add;
    }

    @Override
    public void run() {
        add.sum();
    }
}
class P2 implements Runnable{
    Demo add;

    P2(Demo add)
    {
        this.add=add;
    }

    @Override
    public void run() {
        add.sum();
    }
}





public class MyRunnableInterface {
    public static void main(String[] args) throws InterruptedException {

        Demo demo = new Demo();
        P1 p1 = new P1(demo);
        P2 p2 = new P2(demo);

        Thread t1 = new Thread(p1);
        Thread t2 = new Thread(p2);


        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Sum is :"+demo.Add);

    }
}
