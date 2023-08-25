public interface Board {
    void addMarks(Mark m, Place p);
    void removeMarks(Place p);
    void clearboard();
    String readBoard();
}