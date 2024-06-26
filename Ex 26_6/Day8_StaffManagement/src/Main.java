import vn.edu.likelion.Abstracts.AStaff;
import vn.edu.likelion.Entities.Manager;
import vn.edu.likelion.Entities.Programmer;

public class Main {
    public static void main(String[] args) {

        AStaff manager = new Manager(1, "Corona Cadogan", 6000, 1000);
        AStaff programmer = new Programmer(2, "Antal Nuka", 5000, 20, 25);

        manager.showInfo();
        System.out.println("---------------------------------");
        programmer.showInfo();
    }
}