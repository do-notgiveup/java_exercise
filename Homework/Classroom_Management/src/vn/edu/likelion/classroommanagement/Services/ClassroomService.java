package vn.edu.likelion.classroommanagement.Services;

import vn.edu.likelion.classroommanagement.Entities.Classroom;
import vn.edu.likelion.classroommanagement.Entities.Student;
import vn.edu.likelion.classroommanagement.Interfaces.IClassroomServiceInterface;

import java.time.LocalDate;
import java.util.Random;

public class ClassroomService implements IClassroomServiceInterface {

    // dang ky hoc vien vao lop
    @Override
    public void registerStudent(Student student, Classroom classroom) {
        Random r = new Random();
        // lop hoc add den nguoi thu n-1
        if (classroom.getStudents().size() < classroom.getNumOfTable() - 1) {
            classroom.getStudents().add(student);
            student.setStudentCode("SC" + r.nextInt(50));
            // khi den nguoi thu n thi add them nua lop se day,
            // tien hanh start lop va cap nhat lai thong tin cua cac hv trong lop
        } else if (classroom.getStudents().size() == classroom.getNumOfTable() - 1) {
            classroom.getStudents().add(student);
            student.setStudentCode("SC" + r.nextInt(50));
            for (Student stu : classroom.getStudents()) {
                stu.setEnroll(LocalDate.now());
                stu.setStatus(true);
            }
            classroom.setStatus(true);
        } else System.out.println("lop da day");
    }

    // hien thi danh sach hoc vien cua lop
    @Override
    public void getAllStudentInClass(Classroom classroom) {
        for (Student stu : classroom.getStudents()) {
            System.out.println(stu);
        }
    }

    // thay doi thong tin cua hoc vien
    @Override
    public void updateInfoStudent(int id, String name, LocalDate yob, String cccd, Classroom classroom) {
        Student stu = getStudentById(id, classroom);
        if (stu != null) {
            stu.setName(name);
            stu.setYob(yob);
            stu.setCccd(cccd);
        } else System.out.println("khong tim thay hv");
    }

    // thay doi trang thai va them li do cho hoc vien bo hoc
    @Override
    public void removeStuOutClass(int id, String reason, Classroom classroom) {
        Student stu = getStudentById(id, classroom);
        if (stu != null) {
            stu.setStatus(false);
            stu.setReason(reason);
//            classroom.getStudents().remove(getStudentById(id, classroom));
        } else System.out.println("khong tim thay hv");
    }

    // lay hoc vien dua tren id hoc vien va lop hoc
    @Override
    public Student getStudentById(int id, Classroom classroom) {
        for (Student stu : classroom.getStudents()) {
            if (stu.getId() == id) return stu;
        }
        return null;
    }
}
