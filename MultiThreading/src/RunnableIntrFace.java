class AKka extends Thread
{
    @Override
    public void run() {
        System.out.println("hii i am sam");
    }
}

class RunnableInterFace
{
    public static void main(String[] args) {
        AKka a1= new AKka();
        a1.start();
    }
}