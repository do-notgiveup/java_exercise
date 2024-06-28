public class Bike extends Vehicle{
    private boolean hasGear;

    public Bike(boolean hasGear, String name, int id){
        super(name, id);
        this.hasGear = hasGear;
    }

    @Override
    public void move(){
        System.out.println("Bike is moving");
    }
}
