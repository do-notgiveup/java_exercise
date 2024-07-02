package vn.edu.likelion.classroommanagement.Entities;

import java.time.LocalDate;

public class Student {
    private int id;
    private String name;
    private LocalDate yob;
    private String cccd;
    // ma học sinh
    private String studentCode;
    // trạng thái học của học sinh (true->hoc, false -> nghi)
    private boolean status;
    // li do nghi
    private String reason;
    //ngay nhap hoc
    private LocalDate enroll;

    public Student(int id, String name, LocalDate yob, String cccd, String studentCode, boolean status,
                   String reason, LocalDate enroll) {
        this.id = id;
        this.name = name;
        this.yob = yob;
        this.cccd = cccd;
        this.studentCode = studentCode;
        this.status = status;
        this.reason = reason;
        this.enroll = enroll;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getYob() {
        return yob;
    }

    public void setYob(LocalDate yob) {
        this.yob = yob;
    }

    public String getCccd() {
        return cccd;
    }

    public void setCccd(String cccd) {
        this.cccd = cccd;
    }

    public String getStudentCode() {
        return studentCode;
    }

    public void setStudentCode(String studentCode) {
        this.studentCode = studentCode;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public LocalDate getEnroll() {
        return enroll;
    }

    public void setEnroll(LocalDate enroll) {
        this.enroll = enroll;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", yob=" + yob +
                ", cccd='" + cccd + '\'' +
                ", studentCode='" + studentCode + '\'' +
                ", status=" + status +
                ", reason='" + reason + '\'' +
                ", enroll=" + enroll +
                '}';
    }
}