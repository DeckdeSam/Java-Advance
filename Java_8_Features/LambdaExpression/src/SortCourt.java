import java.util.*;

public class SortCourt {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Amit", "Ravi", "Sonal");

        // Using method reference instead of lambda
        names.forEach(System.out::println);
    }
}

