import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //bai 1
        int[] intArray = new int[]{5, 1, 8, 4, 9, 1, 5};
        System.out.println("Sum: " + getSumOfDistinct(intArray));

        //bai 2
        System.out.print("Original String: ");
        System.out.println("Output String: " + printDoubleChar(sc.nextLine()));

        //bai 3
        int[] numbers = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        coutNumberOddEven(numbers);

        //bai 4
        System.out.print("Input String: ");
        removeDuplicateChar(sc.nextLine());

        //bai 5
        swapString("Hello", "World");

        //bai 6
        System.out.print("How many numbers do you want to input? ");
        throwDuplicate(sc.nextInt());
    }

    public static int getSumOfDistinct(int[] intArray) {
        //thêm từng số vào HashSet de tu dong loai bo so trung lap
        HashSet<Integer> setInt = new HashSet();
        int sum = 0;
        for (int i = 0; i < intArray.length; i++) {
            setInt.add(intArray[i]);
        }

        //dung iterator de duyet tung phan tu cua HashSet
        Iterator interate = setInt.iterator();
        while (interate.hasNext()) {
            sum = sum + interate.next().hashCode();
        }
        return sum;
    }

    public static StringBuffer printDoubleChar(String str) {
        //StringBuffer cho phep chinh sua chuoi nhieu lan ma k them chuoi moi
        StringBuffer strBuffer = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            // add ki tu 2 lan
            strBuffer.append(str.charAt(i));
            strBuffer.append(str.charAt(i));
        }
        return strBuffer;
    }

    public static void coutNumberOddEven(int[] numbers) {
        int even = 0;
        int odd = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] != 0) {//0 k phai so chan,le
                if (numbers[i] % 2 == 0) even++;
                else odd++;
            }
        }

        System.out.println("Number of even elements: " + even);
        System.out.println("Number of odd elements: " + odd);
    }

    public static void removeDuplicateChar(String str) {
//        String string = new String();
//        //for 1 lay tung ki tu ra de so sanh voi cac ki tu khac
//        for (int i = 0; i < str.length(); i++) {
//            String c = String.valueOf(str.charAt(i));
//            //for 2 so sanh chuoi string k chua ki tu c thi add vao chuoi
//            for (int j = i + 1; j <= str.length(); j++) {
//                if (!string.contains(c)) string += c;
//            }
//        }

        StringBuilder string = new StringBuilder();
        string.append(str);
        for (int i = 0; i < str.length(); i++) {
            String c = String.valueOf(str.charAt(i));
            if (str.lastIndexOf(c) >= 0 && str.lastIndexOf(c) != i)
                string.deleteCharAt(string.lastIndexOf(c));
        }

        System.out.println("Output String without duplicate: " + string);
    }

    public static void swapString(String str1, String str2) {
        System.out.println("\nString before swap:");
        System.out.println("String 1: " + str1);
        System.out.println("String 2: " + str2);

        //cong 2 str lai voi nhau, str2 truoc str1
        str1 = str2 + str1;
        //str2 = phan duoi str1
        str2 = str1.substring(str2.length());
        //str1 lay lai tu dau chuoi den do dai str2
        str1 = str1.substring(0, str2.length());

        System.out.println("\nString after swap:");
        System.out.println("String 1: " + str1);
        System.out.println("String 2: " + str2);
    }

    public static void throwDuplicate(int num) {
        Scanner sc = new Scanner(System.in);
        int flag = 0;
        ArrayList<Integer> intArray = new ArrayList<>();
        System.out.println("Input the integers: ");
        for (int i = 0; i < num; i++) {
            int number = sc.nextInt();
            if (flag == 0) {
                if (intArray.contains(number)) flag = number;
            }
            intArray.add(number);
        }

        if (flag == 0) System.out.println("No duplicate numbers!");
        else System.out.println("Error: Duplicate numbers found: " + flag);
    }
}