public class Main {
    int a;
    static int b;

    public static void main(String[] args) {
        bai1();
        System.out.println("");
        bai2();
        System.out.println("");
        bai3();
        System.out.println("");
        bai4();
    }

    public static void bai1() {
        Vehicle vehicle = new Vehicle();
        vehicle.speedUp();

        Car car = new Car();
        car.speedUp();

        Bicycle bicycle = new Bicycle();
        bicycle.speedUp();
    }

    public static void bai2() {
        NhanVien nhanVien = new NhanVien();
        nhanVien.work();
        nhanVien.getSalary();

        HRManager hrManager = new HRManager();
        hrManager.work();
        hrManager.getSalary();
        hrManager.addEmployee();
    }

    public static void bai3() {
        Manager3 manager3 = new
                Manager3("Avril Aroldo", "VN", 12000, "managing a project"
        , 12000, "Excellent");
        Developer3 developer3 = new
                Developer3("Iver Dipali", "Good", 7200, "writing code in Java"
        , 7200, "Good");
        Programmer3 programmer3 = new
                Programmer3("Yaron Gabriel", "Excelent", 9120,
                "debugging code in Python", 9120, "Excellent");

        manager3.getBonus();
        developer3.getBonus();
        programmer3.getBonus();
        manager3.getPerformanceReport();
        developer3.getPerformanceReport();
        programmer3.getPerformanceReport();
        manager3.getJobTitle();
        developer3.getJobTitle();
        programmer3.getJobTitle();
    }

    public static void bai4(){
        Truck truck = new Truck("Tatra 810 4x4", "Rectangle", 2024, "Electric",
        8.075659532105526, 65.50975012444003, 80);
        Car4 car4 = new Car4("Virtus", "Rectangle", 2024, "Electric",
                2.355, 14.419665, 120);
        Motorcycle motorcycle = new Motorcycle("Warrior200", "Rectangle", 2024,
                "Electric", 2.1, 4.41, 80);

        truck.getModel();
        truck.getFuelEfficiency();
        truck.getDistanceTraveled();
        truck.getMaxSpeed();
        System.out.println("Time: " + truck.getTime() + " miles/mph");

        System.out.println();
        car4.getModel();
        car4.getFuelEfficiency();
        car4.getDistanceTraveled();
        car4.getMaxSpeed();
        System.out.println("Time: " + car4.getTime() + " miles/mph");

        System.out.println();
        motorcycle.getModel();
        motorcycle.getFuelEfficiency();
        motorcycle.getDistanceTraveled();
        motorcycle.getMaxSpeed();
        System.out.println("Time: " + motorcycle.getTime() + " miles/mph");
    }
}


