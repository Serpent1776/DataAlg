public abstract class employee {
    private String name;
    private String position;
    public employee(String name, String position) {
        this.name = name;
        this.position = position;
    }
    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public abstract double pay();
    
    public String toString() {
        return name + ", " + position;
    }
}
