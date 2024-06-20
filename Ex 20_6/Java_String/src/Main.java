import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("The given string is: ");

        System.out.println("The first non repeated character in String is: "
                + getCharNonRepeat(sc.nextLine()));

        String[] strArray = {"Red", "Green", "Orange", "White", "Black"};
        System.out.print("List before sort: ");
        for (int i = 0; i <= strArray.length - 1; i++) {
            System.out.print(strArray[i] + " ");
        }
        System.out.println();

        System.out.print("List after sort: ");
        String[] sortString = sortString(strArray);
        for (int i = 0; i <= sortString.length - 1; i++) {
            System.out.print(sortString[i] + " ");
        }
    }

    public static char getCharNonRepeat(String str) {
        char getChar = str.charAt(0);
        for (int i = 1; i <= str.length() - 1; i++) {
            if (i != str.length() - 1 && str.charAt(i) != getChar
                    && str.charAt(i + 1) != str.charAt(i)) {
                getChar = str.charAt(i);
            } else if (i == str.length() - 1 && str.charAt(i) != getChar) {
                getChar = str.charAt(i);
            } else break;
        }
        return getChar;
    }

    public static String[] sortString(String[] str) {
        for (int i = 0; i < str.length - 1; i++) {
            for (int j = i + 1; j < str.length; j++) {
                if (str[i].compareTo(str[j]) > 0) {
                    String temp = str[i];
                    str[i] = str[j];
                    str[j] = temp;
                }
            }
        }
        return str;
    }
}
