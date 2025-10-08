// Class to hold a shared integer value
class Addition1 {
    private int add = 0;

    // synchronized method to ensure thread-safety
    synchronized void sum() {
        add = add + 1;
    }

    static int getValue() {
        return add;
    }
}

// Thread class that increments the shared 'Addition' object
class ProblemThread1 extends Thread {
    private final Addition1 addition;

    ProblemThread1(Addition1 addition) {
        this.addition = addition;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 1000; i++) {
            addition.sum();
        }
    }
}

// Main class
public class ProblemSolve {
    public static void main(String[] args) throws InterruptedException {
        Addition sharedAddition = new Addition();

        // Create and start threads
        ProblemThread t1 = new ProblemThread(sharedAddition);
        ProblemThread t2 = new ProblemThread(sharedAddition);

        t1.start();
        t2.start();

        // Wait for both threads to finish
        t1.join();
        t2.join();

        // Output final value
        System.out.println("Final value of add: " + Addition1.getValue());
    }
}
