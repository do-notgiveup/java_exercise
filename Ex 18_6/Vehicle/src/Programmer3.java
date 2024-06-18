public class Programmer3 extends NhanVien3 {
    public Programmer3(String name, String address, double salary, String jobTitle,
                       double bonus, String performanceReport) {
        super(name, address, salary, jobTitle, bonus, performanceReport);
    }

    @Override
    public void getBonus(){
        System.out.println("Programmer's Bonus: $" + bonus);
    }

    @Override
    public void getPerformanceReport(){
        System.out.println("Performance report for Programmer " + name + ": " + performanceReport);
    }

    @Override
    public void getJobTitle(){
        System.out.println("Programmer " + name + " is: " + jobTitle);
    }
}
