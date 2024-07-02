package vn.edu.likelion.classroommanagement.Entities;

import java.util.ArrayList;

public class Classroom {
    private int id;
    private String name;
    // so ban, toi da 10 ban, moi ban 1 hoc vien
    private int numOfTable;
    // so luong hoc sinh du kien du de mo lop
    private int numOfExpect;
    // trang thai cua lop hoc
    boolean status;
    // danh sach hoc vien cua 1 lop
    private ArrayList<Student> students = new ArrayList<>();

    public Classroom(int id, String name, int numOfTable, int numOfExpect, boolean status) {
        this.id = id;
        this.name = name;
        this.numOfTable = numOfTable;
        this.numOfExpect = numOfExpect;
        this.status = status;
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

    public int getNumOfTable() {
        return numOfTable;
    }

    public void setNumOfTable(int numOfTable) {
        this.numOfTable = numOfTable;
    }

    public int getNumOfExpect() {
        return numOfExpect;
    }

    public void setNumOfExpect(int numOfExpect) {
        this.numOfExpect = numOfExpect;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
