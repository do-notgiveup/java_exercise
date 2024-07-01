public class CourseOnline extends Course implements ICourseInterface {
    String platform;
    double duration;

    public CourseOnline(int courseId, String courseName, String mentorName, int credit,
                        String platform, double duration) {
        super(courseId, courseName, mentorName, credit);
        this.platform = platform;
        this.duration = duration;
    }

    @Override
    public String displayDetailCourse() {
        return "CourseOnline{" +
                "courseId=" + courseId +
                ", courseName='" + courseName + '\'' +
                ", mentorName='" + mentorName + '\'' +
                ", credit=" + credit +
                ", platform='" + platform + '\'' +
                ", duration=" + duration +
                '}';
    }

    @Override
    public void displayStudent() {
        for (Student student : students) {
            System.out.println(student);
        }
    }

    public void addStudent(Student stu) {
        students.add(stu);
    }
}
