class Demoo {
    int Add = 0;


    void sum() {
        for (int i = 1; i <= 1000; i++) {
            Add = Add + 1;
        }
    }
}

class P4 implements Runnable{
    Demoo add;

    P4(Demoo add)
    {
        this.add=add;
    }

    @Override
    public void run() {
        add.sum();
    }
}
class P3 implements Runnable{
    Demoo add;

    P3(Demoo add)
    {
        this.add=add;
    }

    @Override
    public void run() {
        add.sum();
    }
}





public class MyRunnableInterfacee {
    public static void main(String[] args) throws InterruptedException {

        Demoo demo = new Demoo();

        Thread t1 = new Thread(new P4(demo));
        Thread t2 = new Thread(new P3(demo));


        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Sum is :"+demo.Add);

    }
}
