public class MountainBike extends Bike {
    private int gears;
    private boolean waterHolder;
    
    public MountainBike(int wheels, String frame, int brakes, double weight, int gears, boolean waterHolder) {
        super(wheels, frame, brakes, weight);
        this.gears = gears;
        this.waterHolder = waterHolder;
    }
}
