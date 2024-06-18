public class Vehicle4 {
    String model;
    String shape;
    double year;
    String fule;
    double fuleEfficiency;
    double distance;
    double maxSpeed;
    double time;

    public Vehicle4(String model, String shape, double year, String fule,
                    double fuleEfficiency, double distance, double maxSpeed) {
        this.model = model;
        this.shape = shape;
        this.year = year;
        this.fule = fule;
        this.fuleEfficiency = fuleEfficiency;
        this.distance = distance;
        this.maxSpeed = maxSpeed;
    }

    public void getModel(){}

    public void getFuelEfficiency(){}

    public void getDistanceTraveled(){}

    public void getMaxSpeed(){}

    public double getTime(){
        return distance/maxSpeed;
    }
}
