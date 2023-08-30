public class Bike {
    private int wheels;
    private String frame;
    private int brakes;
    private double weight;
    private TravelBike travel;
    private MountainBike hardtail;

    public Bike(wheels, frame, brakes, weight, travel, hardtail) {
        this.wheels = wheels;
        this.frame = frame;
        this.brakes = brakes;
        this.weight = weight;
        this.travel = travel;
        this.hardtail = hardtail;
    }
    public Bike(wheels, frame, brakes, weight) {
        this.wheels = wheels;
        this.frame = frame;
        this.brakes = brakes;
        this.weight = weight;
    }
}
