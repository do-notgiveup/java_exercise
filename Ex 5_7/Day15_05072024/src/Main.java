import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class Main {
    static int sumChan = 0;
    static int sumLe = 0;

    public static void main(String[] args) {
        System.out.println("Hello world!");

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 12, 14, 14, 14, 14);

        //bai 1
        list.stream().forEach(s -> {
            if (s % 2 == 0) sumChan += s;
            else sumLe += s;
        });

        System.out.println(sumChan);
        System.out.println(sumLe);



        //bai 2
        list.stream().distinct().forEach(System.out::println);
        System.out.println(list.stream().distinct().toList());
        System.out.println(list.stream().distinct().collect(Collectors.toList()));

    }
}