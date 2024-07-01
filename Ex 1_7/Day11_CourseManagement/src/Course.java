import java.util.ArrayList;

public class Course {
    int courseId;
    String courseName;
    String mentorName;
    int credit;
    ArrayList<Student> students;

    public Course(int courseId, String courseName, String mentorName, int credit) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.mentorName = mentorName;
        this.credit = credit;
        this.students = new ArrayList<>();
    }
}
