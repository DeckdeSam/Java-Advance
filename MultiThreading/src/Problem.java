
class Addition {
    public int add = 0;

    void sum() {
        add = add + 1;
    }

    int getValue() {
        return add;
    }
}
class ProblemThread extends Thread {
    private final Addition addition;

    ProblemThread(Addition addition) {
        this.addition = addition;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 1000; i++) {
            addition.sum();
        }
    }
}


public class Problem {
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
        System.out.println("Final value of add: " + sharedAddition.getValue());
    }
}
