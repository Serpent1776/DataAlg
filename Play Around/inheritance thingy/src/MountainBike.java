public class MountainBike extends Bike {
    private int gears;
    private boolean waterHolder;
    
    public MountainBike(wheels, frame, brakes, weight, gears, waterHolder) {
        super(wheels, frame, brakes, weight);
        this.gears = gears;
        this.waterHolder = waterHolder;
    }
}
