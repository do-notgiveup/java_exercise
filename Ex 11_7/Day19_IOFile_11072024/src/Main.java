import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static int count = 0;
    static int countTest = 0;
    static List<String> list = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("Nhap ten file");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();

        String fileName = name + ".txt";
        String sourceFile = "a.txt";

        BufferedReader br = null;

        // backup file A vao list static
        try {
            if (list.isEmpty()) {
                String line;
                br = new BufferedReader(new FileReader(sourceFile));
                while ((line = br.readLine()) != null) {
                    list.add(line);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                br.close();
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }


        try {
            WriteFileThread a = new WriteFileThread(fileName);
            Thread thread1 = new Thread(a);
            Thread thread2 = new Thread(new DeleteFileThread(sourceFile));
            thread1.start();
//            thread2.start();
            do {
                Thread.sleep(1000);
                System.out.println("tiep");
                if (sc.nextInt() != 0 && count < list.size()) {
//                    thread1.notify();
                } else {
                    System.out.println("het hv");
                    break;
                }
            } while (true);
        } catch (Exception io) {
//            io.getMessage();
            io.printStackTrace();
        }
    }
}