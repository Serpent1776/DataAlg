public class TravelBike extends Bike {
    private boolean somethingInBucket;

    public TravelBike(wheels, frame, brakes, weight, somethingInBucket) {
        super(wheels, frame, brakes, weight);
        this.somethingInBucket = somethingInBucket;
    }
}
