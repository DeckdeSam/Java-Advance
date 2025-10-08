// Class to hold a shared integer value
class Addition1 {
   public int add = 0;

    // synchronized method to ensure thread-safety
    synchronized void sum() {
        add = add + 1;
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
class ProblemThread2 extends Thread {
    private final Addition1 addition;

    ProblemThread2(Addition1 addition) {
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
        Addition1 sharedAddition = new Addition1();

        // Create and start threads
        ProblemThread1 t1 = new ProblemThread1(sharedAddition);
        ProblemThread2 t2 = new ProblemThread2(sharedAddition);



        t1.start();
        t2.start();

        // Wait for both threads to finish
        t1.join();
        t2.join();

        // Output final value
        System.out.println("Final value of add: " + sharedAddition.add);
    }
}
