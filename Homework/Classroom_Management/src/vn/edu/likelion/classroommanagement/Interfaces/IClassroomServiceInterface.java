package vn.edu.likelion.classroommanagement.Interfaces;

import vn.edu.likelion.classroommanagement.Entities.Classroom;
import vn.edu.likelion.classroommanagement.Entities.Student;

import java.time.LocalDate;

public interface IClassroomServiceInterface {

    // dang ky hoc vien vo lop
    void registerStudent(Student student, Classroom classroom);

    // xem hoc vien trong lop
    void getAllStudentInClass(Classroom classroom);

    // sua thong tin hoc vien
    void updateInfoStudent(int id, String name, LocalDate yob, String cccd, Classroom classroom);

    //hoc vien bo hoc
    void removeStuOutClass(int id, String reason, Classroom classroom);

    // tim hoc vien bang id
    Student getStudentById(int id, Classroom classroom);
}
