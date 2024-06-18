public class Developer3 extends NhanVien3 {
    public Developer3(String name, String address, double salary, String jobTitle,
                      double bonus, String performanceReport) {
        super(name, address, salary, jobTitle, bonus, performanceReport);
    }

    @Override
    public void getBonus(){
        System.out.println("Developer's Bonus: $" + bonus);
    }

    @Override
    public void getPerformanceReport(){
        System.out.println("Performance report for Developer " + name + ": " + performanceReport);
    }

    @Override
    public void getJobTitle(){
        System.out.println("Developer " + name + " is: " + jobTitle);
    }
}
