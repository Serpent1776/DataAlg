import DSQueuestuff.*;
public class QueueDriver {
    public static void main(String[] args) {
        try {
        DSLinkedQueue<Integer> sus =  new DSLinkedQueue<Integer>();
        sus.enqueue(3);
        sus.enqueue(1);
        sus.enqueue(1);
        sus.enqueue(1);
        sus.enqueue(2);
        System.out.println(sus);
        sus.moveToFront();
        System.out.println(sus);
        } catch(Exception e) {
            System.out.print(e.getMessage());
        }
    }
}
