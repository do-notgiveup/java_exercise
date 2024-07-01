public class CourseApp {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        CourseOnline courseOnline = new CourseOnline(1, "Hello Java",
                "Tuan", 4, "GG Meet", 30);

        Student s1 = new Student(1, "Nguyen", 18);
        Student s2 = new Student(2, "Hoang", 18);
        Student s3 = new Student(3, "Bao", 18);
        Student s4 = new Student(4, "An", 18);

        courseOnline.addStudent(s1);
        s1.name = "hello";
        courseOnline.addStudent(s2);
        courseOnline.addStudent(s3);
        courseOnline.addStudent(s4);

        System.out.println("-----------------------------------");
        System.out.println(courseOnline.displayDetailCourse() + "\n");
        courseOnline.displayStudent();
    }
}