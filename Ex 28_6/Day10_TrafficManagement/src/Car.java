public class Car extends  Vehicle{
    private int numerOfDoors;

    public Car(int numerOfDoors, String name, int id){
        super(name, id);
        this.numerOfDoors = numerOfDoors;
    }

    @Override
    public void move(){
        System.out.println("Car is moving");
    }
}
