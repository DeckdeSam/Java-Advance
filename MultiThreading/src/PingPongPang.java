class SharedR {
    int state = 0;  // 0 = Ping, 1 = Pong, 2 = Pang

    synchronized void ping() throws InterruptedException {
        while (state != 0) {
            wait();
        }
        System.out.println("Ping");
        Thread.sleep(500);  // Optional delay
        state = 1;
        notifyAll();
    }

    synchronized void pong() throws InterruptedException {
        while (state != 1) {
            wait();
        }
        System.out.println("Pong");
        Thread.sleep(500);
        state = 2;
        notifyAll();
    }

    synchronized void pang() throws InterruptedException {
        while (state != 2) {
            wait();
        }
        System.out.println("Pang");
        Thread.sleep(500);
        state = 0;
        notifyAll();
    }
}

class Ping extends Thread {
    SharedR shared;

    Ping(SharedR shared) {
        this.shared = shared;
    }

    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
                shared.ping();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Pong extends Thread {
    SharedR shared;

    Pong(SharedR shared) {
        this.shared = shared;
    }

    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
                shared.pong();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Pang extends Thread {
    SharedR shared;

    Pang(SharedR shared) {
        this.shared = shared;
    }

    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
                shared.pang();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class PingPongPang {
    public static void main(String[] args) {
        SharedR shared = new SharedR();

        Ping ping = new Ping(shared);
        Pong pong = new Pong(shared);
        Pang pang = new Pang(shared);

        ping.start();
        pong.start();
        pang.start();
    }
}
