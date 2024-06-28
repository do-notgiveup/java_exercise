public abstract class Vehicle {
    private String name;
    private final int id;
    private static int vehicleCount;

    public Vehicle(String name, int id) {
        this.name = name;
        this.id = id;
        vehicleCount++;
    }

    public static int getVehicleCount() {
        return vehicleCount;
    }

    public abstract void move();
}
