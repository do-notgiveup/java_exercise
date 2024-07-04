import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        //bai1
        bai1();

        //bai2
        bai2("Madam");
        bai2("radar");
        bai2("defied");

        //bai3
        bai3();

    }

    public static void bai1() {
        List<Double> list = new ArrayList<>();
        list.add(1.2);
        list.add(2.3);
        list.add(3.4);
        list.add(4.5);
        list.add(5.6);
        list.add(6.7);

        ICalculator i = (list1) -> {
            double sum = 0;
            for (Double v : list1) {
                sum += v;
            }
            System.out.printf("%.2f\n", sum / list1.size());
        };
        i.sum(list);
    }

    public static void bai2(String string) {
        IPalindromeString p = (string1) -> {
            boolean check = true;
            for (int i = 0; i < (int) string1.length() / 2; i++) {
                if (string1.charAt(i) != string1.charAt(string1.length() - 1 - i)) {
                    check = false;
                    break;
                }
            }
            System.out.println(string1 + " is a palindrome? " + check);
        };
        p.isPalindome(string);
    }

    public static void bai3() {
        List<Integer> integers = Arrays.asList(1, 7, 18, 25, 77, 300, 101);
        Consumer<List<Integer>> c = (list) -> {
            System.out.println(list.stream().sorted().toList().get(list.size() - 2));
            System.out.println(list.stream().sorted().toList().get(0));
        };
        c.accept(integers);
    }
}