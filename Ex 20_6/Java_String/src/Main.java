import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("The given string is: ");

        System.out.println("The first non repeated character in String is: "
                + firstNonRepeatCharacterByLoop(sc.nextLine()));

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

//    public static char getCharNonRepeat(String str) {
////        char getChar = str.charAt(0);
////        for (int i = 1; i <= str.length() - 1; i++) {
////            if (i != str.length() - 1 && str.charAt(i) != getChar
////                    && str.charAt(i + 1) != str.charAt(i)) {
////                getChar = str.charAt(i);
////            } else if (i == str.length() - 1 && str.charAt(i) != getChar) {
////                getChar = str.charAt(i);
////            } else break;
////        }
////        return getChar;
//        char c = 0;
//        for (int i = 0; i < str.length(); i++) {
//            c = str.charAt(i);
//            for (int j = 0; j < str.length(); j++) {
//                if (i != j && str.charAt((j)) == c)
//
//            }
//        }
//        return c;
//    }

    public static String firstNonRepeatCharacterByLoop(String input){
        // for 1: duyệt ký tự đầu tiên đến ký tự cuối của String.
        for(int i = 0; i < input.length(); i++){
            // đặt biến cờ là true
            boolean flag = true;
            // for 2: duyệt ký tự tiếp theo của input[i] đến cuối chuỗi
            for(int j = i + 1; j < input.length(); j++){
                // so sánh 2 ký tự liền kề nhau, nếu giống nhau thì có trùng lặp va thoát khỏi vòng lặp này
                // và tiếp tục duyệt ký tự tiếp theo.
                if(input.charAt(i) == input.charAt(j)){
                    flag = false;
                    break;
                }
            }
            // nếu biến flag là true tức là ko có ký tự trùng lặp thì lập tức trả về
            if(flag) return String.valueOf(input.charAt(i));
        }
        // ngược lại ko có ký tự mà ko có sự trung lặp thì trả về null.
        return null;
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
