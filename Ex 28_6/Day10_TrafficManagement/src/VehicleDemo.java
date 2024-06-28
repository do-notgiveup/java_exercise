public class VehicleDemo {
    public static void main(String[] args) {

        Vehicle[] vehicles = new Vehicle[]{
                new Car(4, "Mercedes", 1),
                new Bike(false, "Martin", 2)
        };

        for (int i = 0; i < vehicles.length; i++) {
            vehicles[i].move();
        }
        System.out.println(Vehicle.getVehicleCount());
    }
}