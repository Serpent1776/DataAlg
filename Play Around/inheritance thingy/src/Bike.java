public class Bike {
    private int wheels;
    private String frame;
    private int brakes;
    private double weight;
    private TravelBike travel;
    private MountainBike hardtail;

    public Bike(int wheels, String frame, int brakes, double weight, TravelBike travel, MountainBike hardtail) {
        this.wheels = wheels;
        this.frame = frame;
        this.brakes = brakes;
        this.weight = weight;
        this.travel = travel;
        this.hardtail = hardtail;
    }
    public Bike(int wheels, String frame, int brakes, double weight) {
        this.wheels = wheels;
        this.frame = frame;
        this.brakes = brakes;
        this.weight = weight;
    }
    public MountainBike getHardtail() {
        return hardtail;
    }
    public String toString() {
        if(travel != null && hardtail != null) {
        return wheels + frame + brakes + weight + "\n" + travel + "\n" + hardtail;
        } else {
            return wheels + frame + brakes + weight;
        }
    }
}
