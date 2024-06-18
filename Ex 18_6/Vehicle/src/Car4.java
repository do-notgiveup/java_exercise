public class Car4 extends Vehicle4{
    public Car4(String model, String shape, double year, String fule,
                double fuleEfficiency, double distance, double maxSpeed) {
        super(model, shape, year, fule, fuleEfficiency, distance, maxSpeed);
    }

    @Override
    public void getModel(){
        System.out.println("Car Model: " + model);
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
