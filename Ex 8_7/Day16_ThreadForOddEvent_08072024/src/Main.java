import java.util.ArrayList;
import java.util.List;

public class Main {
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("Hello world!");

        for (int i = 0; i < 20; i++) {
            list.add(i + 1);
        }
        for (Integer i : list) {
            System.out.print(i + " ");
        }

        //thread 1
//        Runnable task1 = new EvenThread(list);
        Thread thread1 = new EvenThread(list);
        thread1.start();

        //thread 2
//        Runnable task2 = new OddThread(list);
        Thread thread2 = new OddThread(list);
        thread2.start();
    }
}