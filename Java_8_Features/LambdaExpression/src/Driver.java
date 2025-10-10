public class Driver {
    public static void main(String[] args) {

     /*   MyRunnable myRunnable = new MyRunnable();
        Thread thread = new Thread(myRunnable);
        thread.start();
       */


        // lambda expression to shortHand to implement code
//        LambdaDemo lambdaDemo = ()-> System.out.println("I am override :");
//        lambdaDemo.sum();

        MultiAno multiAno = ()-> System.out.println("I am overrider");
        multiAno.sum();

    }
}
