public class hourlyemployee extends employee {
   private double hours;
   private double rate;
   
   public hourlyemployee(double hours, double rate, String name, String pos) {
    super(name, pos);
    this.rate = rate;
    this.hours = hours;
   }
   public double getHours() {
       return hours;
   }
   public double getRate() {
       return rate;
   }
   @Override
   public double pay() {
    return hours*rate;
   }
}
