import DSQueuestuff.*;
public class QueueDriver {
    public static void main(String[] args) {
        try {
        LinkedQueue<Integer> sus =  new LinkedQueue<Integer>();
        sus.enQueue(3);
        sus.enQueue(1);
        sus.enQueue(1);
        sus.enQueue(1);
        sus.enQueue(2);
        System.out.println(sus);
        sus.moveToFront();
        System.out.println(sus);
        } catch(Exception e) {
            System.out.print(e.getMessage());
        }
    }
}
