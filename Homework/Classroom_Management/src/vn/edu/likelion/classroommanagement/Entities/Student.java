package vn.edu.likelion.classroommanagement.Entities;

import java.time.LocalDateTime;

public class Student {
    int id;
    String name;
    LocalDateTime yob;
    String cccd;

    public Student(int id, String name, LocalDateTime yob, String cccd) {
        this.id = id;
        this.name = name;
        this.yob = yob;
        this.cccd = cccd;
    }
}
