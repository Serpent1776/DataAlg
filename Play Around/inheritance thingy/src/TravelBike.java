public class TravelBike extends Bike {
    private boolean somethingInBucket;

    public TravelBike(int wheels, String frame, int brakes, double weight, boolean somethingInBucket) {
        super(wheels, frame, brakes, weight);
        this.somethingInBucket = somethingInBucket;
    }
}
