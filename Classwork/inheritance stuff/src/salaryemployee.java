public class salaryemployee extends employee {
    private double salary;
    public salaryemployee(String name, String pos, double salary) {
        super(name, pos);
        this.salary = salary;
    }
    @Override
    public double pay() {
        return salary;
    }
}
