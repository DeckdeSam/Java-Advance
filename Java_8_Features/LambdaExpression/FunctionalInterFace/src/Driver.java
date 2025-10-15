import java.text.Collator;

public class Driver {
    public static void main(String[] args) {
        FunctionalIntrfaceDemo fi=(a,b)-> System.out.println("the Sum is "+(a+b));
        fi.add(50,60);


        Number number = (x)-> System.out.println("this is the number "+x);
        number.fun1(50);

        Number1 number1 = x -> System.out.println("X-> "+x);
        number1.fun1(5);


    }
}
