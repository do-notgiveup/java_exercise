import vn.edu.likelion.classroommanagement.Entities.Classroom;
import vn.edu.likelion.classroommanagement.Entities.Student;
import vn.edu.likelion.classroommanagement.Services.ClassroomService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        ArrayList<Student> studentArrayList = new ArrayList<>();
        for (int i = 1; i <= 11; i++) {
            studentArrayList.add(new Student(i, "Student" + i, LocalDate.parse("2001-03-12"), "0123456789",
                    "", false, "", null));
        }
//        studentArrayList.add(new Student(1, "An", LocalDate.parse("2001-03-12"), "0123456789",
//                "", false, "", null));
//        studentArrayList.add(new Student(2, "Binh", LocalDate.parse("2001-03-12"), "0123456789",
//                "", false, "", null));
//        studentArrayList.add(new Student(3, "Cuong", LocalDate.parse("2001-03-12"), "0123456789",
//                "", false, "", null));
//        studentArrayList.add(new Student(4, "Duong", LocalDate.parse("2001-03-12"), "0123456789",
//                "", false, "", null));
//        studentArrayList.add(new Student(5, "Giang", LocalDate.parse("2001-03-12"), "0123456789",
//                "", false, "", null));
//        studentArrayList.add(new Student(6, "Lan", LocalDate.parse("2001-03-12"), "0123456789",
//                "", false, "", null));

        Classroom c = new Classroom(1, "java can ban", 10, 10, false);

        Scanner sc = new Scanner(System.in);
        ClassroomService cs = new ClassroomService();
        int choose = 0;
        int count = 0;
        do {
            try {
                menu();
                System.out.print("chon di: ");
                choose = Integer.parseInt(sc.nextLine());
                switch (choose) {
                    case 1: {
                        if (count < studentArrayList.size()) {
                            if (LocalDate.now().plusYears(-18).compareTo(studentArrayList.get(count).getYob()) >= 0)
                                cs.registerStudent(studentArrayList.get(count), c);
                            else System.out.println("chua du tuoi");
                            count++;
                        } else System.out.println("da het hv");
                    }
                    break;
                    case 2: {
                        cs.getAllStudentInClass(c);
                    }
                    break;
                    case 3: {
                        System.out.print("nhap id hv: ");
                        int id = Integer.parseInt(sc.nextLine());
                        System.out.print("nhap name: ");
                        String name = sc.nextLine();
                        System.out.print("nhap ngay thang nam sinh (yyyy-MM-dd): ");
                        LocalDate yob = LocalDate.parse(sc.nextLine());
                        System.out.print("nhap cccd: ");
                        String cccd = sc.nextLine();
                        cs.updateInfoStudent(id, name, yob, cccd, c);
                    }
                    break;
                    case 4: {
                        System.out.print("nhap id hv: ");
                        int id = Integer.parseInt(sc.nextLine());
                        System.out.print("nhap li do nghi: ");
                        String reason = sc.nextLine();
                        cs.removeStuOutClass(id, reason, c);
                    }
                    break;
                    case 0: {

                    }
                    default:
                        System.out.println("K ho tro");
                        break;
                }
            } catch (Exception ex) {
                System.out.println("co loi xay ra");
            }
        } while (choose != 0);

    }

    public static void menu() {
        System.out.println("1: dang ki hoc vien");
        System.out.println("2: hien thi danh sach hoc vien");
        System.out.println("3: thay doi thong tin hoc vien");
        System.out.println("4: them hoc vien bo hoc");
        System.out.println("0: cancel and out");
    }
}