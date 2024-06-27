import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        //bai 1
        System.out.println("bai 1");
        int[] list = new int[]{0, 0, 1, 0, 3, 0, 5, 0, 6};
        list = bai1(list);
        for (int i = 0; i < list.length; i++) {
            System.out.print(list[i] + " ");
        }

        //bai 2
        System.out.println("\nbai 2");
        System.out.println(bai2(8642));

        //bai 3
        System.out.println("bai 3");
        bai3(1234);
        bai3(-1234);
        bai3(-34213);
        bai3(4124324);
    }

    public static int[] bai1(int[] list) {
        int[] sortArray = new int[list.length];
        int count = 0;
        for (int i = 0; i < list.length; i++) {
            if (list[i] != 0) {
                sortArray[count] = list[i];
                count++;
            }
        }
        return sortArray;
    }

    public static boolean bai2(int num) {
        System.out.println("Check whether every digit of the said integer is even or not! " + num);
        for (int i = 0; i < String.valueOf(num).length(); i++) {
            if ((num % 10) % 2 != 0) {
                num = num % 10;
            } else return false;
        }
        return true;
    }

    public static void bai3(int num) {
        System.out.println("Extract the first digit from the said integer: " + num);
        if (num < 0) {
            // dùng công thức toán, co the dung chartAt(0)
            System.out.println("-" + (int) (Math.abs(num) / (Math.pow(10, String.valueOf(Math.abs(num)).length() - 1))));
        } else {
            System.out.println((int) (Math.abs(num) / (Math.pow(10, String.valueOf(Math.abs(num)).length() - 1))));
        }

    }
}