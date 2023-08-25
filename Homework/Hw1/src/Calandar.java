/*Identify a thing in real life that could be considered a data structure (like the whiteboard example from class). 
A calandar can be consider a data structure.
What sort of data does this structure contain? 
year, month and date, things a person writes on the calandar, and an image for the month.
What operations can be performed on this data structure (identify at least three)? 
1. display the month.
2. change the month.
3. write on the calandar.
4. erase the writing on the calandar.
5. check if today's date is a holiday.
6. tell today's holiday.
7. archive the caldandar. */
public interface Calandar {
    String display();
    void changeMonth(int month);
    void changeMonth();
    String writeOnCalandar(Pencil writing, int date);
    String writeOnCalandar(Pen writing, int date);
    String eraseWriting(int date);
    boolean holidayCheck();
    String printholiday();
    void archiveCalandar();
}
