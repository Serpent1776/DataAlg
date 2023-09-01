public class App {
    public static void main(String[] args) throws Exception {
       MountainBike mount = new MountainBike(2, "Monster", 4, 156.0, 12, true);
       TravelBike cityBike = new TravelBike(2, "eBike Triple U", 2, 120.0, false);
       Bike allBikes = new Bike(2, "sus", 2, 100, cityBike, mount);
       System.out.print(allBikes);
    }
}
