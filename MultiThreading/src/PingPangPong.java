class SharedR
{
    boolean isFalse=false;
    synchronized void Ping() throws InterruptedException {
        while (isFalse)
        {
            wait();
        }
        System.out.println("Ping");
        Thread.sleep(1000);
        isFalse=true;
        notify();
    }

    synchronized void Pang() throws InterruptedException {
        while (!isFalse)
        {
            wait();
        }
        System.out.println("Pang");
        Thread.sleep(1000);
        Pong();
        isFalse=false;
        notify();
    }
    synchronized void Pong() throws InterruptedException {
        while (!isFalse)
        {
            wait();
        }
        System.out.println("Pong");
        Thread.sleep(1000);
        isFalse=false;
        notify();
    }
}
class Ping extends Thread
{
    SharedR sharedR;
    public Ping(SharedR sharedR)
    {
        this.sharedR=sharedR;
    }

    @Override
    public void run() {
        for (int i = 1; i <=3 ; i++) {
            try {
                sharedR.Ping();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
class Pang extends Thread
{
    SharedR sharedR;
    public Pang(SharedR sharedR)
    {
        this.sharedR=sharedR;
    }

    @Override
    public void run() {
        for (int i = 1; i <=3 ; i++) {
            try {
                sharedR.Pang();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

public class PingPangPong {

    public static void main(String[] args) {


        SharedR sharedR = new SharedR();

        Ping ping = new Ping(sharedR);
        Pang pang = new Pang(sharedR);
        ping.start();
        pang.start();
    }
}

