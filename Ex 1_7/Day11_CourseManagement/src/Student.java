public class Student {
    int studentId;
    String name;
    double age;

    public Student(int studentId, String name, double age) {
        this.studentId = studentId;
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
