public class HRManager extends NhanVien {
    public HRManager() {
    }

    @Override
    public void work() {
        System.out.println("Managing employee!");
    }

    @Override
    public void getSalary() {
        System.out.println("Manager salary: 70000\n");
    }

    public void addEmployee() {
        System.out.println("Adding new employee!");
    }
}
