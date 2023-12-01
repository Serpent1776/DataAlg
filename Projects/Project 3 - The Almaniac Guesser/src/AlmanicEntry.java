import java.util.ArrayList;
public class AlmanicEntry {
    String name;
    String directions;
    ArrayList<String> questions;


    public AlmanicEntry(String name, String directions) {
        this.name = name;
        this.directions = directions;
        questions = new ArrayList<String>(); 
    }
    public String getName() {
        return name;
    }
    public String getDirections() {
        return directions;
    }
    public void incDirections(String d) {
        directions += d;
    }
    public ArrayList<String> getQuestions() {
        return questions;
    }
    public void addToQuestions(String q) {
        questions.add(q);
    }

}
