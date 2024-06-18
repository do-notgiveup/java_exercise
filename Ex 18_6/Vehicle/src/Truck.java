public class Truck extends Vehicle4 {
    public Truck(String model, String shape, double year, String fule,
                 double fuleEfficiency, double distance, double maxSpeed) {
        super(model, shape, year, fule, fuleEfficiency, distance, maxSpeed);
    }

    @Override
    public void getModel(){
        System.out.println("Truck Model: " + model);
    }

    @Override
    public void getFuelEfficiency(){
        System.out.println("Fule Efficiency: " + fuleEfficiency + " mpg");
    }

    @Override
    public void getDistanceTraveled(){
        System.out.println("Distance Traveled: " + distance + " miles");
    }

    @Override
    public void getMaxSpeed(){
        System.out.println("Max Speed: " + maxSpeed + " mph");
    }
}
