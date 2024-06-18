public class Manager3 extends NhanVien3 {
    public Manager3(String name, String address, double salary, String jobTitle,
                    double bonus, String performanceReport) {
        super(name, address, salary, jobTitle, bonus, performanceReport);
    }

    @Override
    public void getBonus(){
        System.out.println("Manager's Bonus: $" + bonus);
    }

    @Override
    public void getPerformanceReport(){
        System.out.println("Performance report for Manager " + name + ": " + performanceReport);
    }

    @Override
    public void getJobTitle(){
        System.out.println("Manager " + name + " is: " + jobTitle);
    }
}
