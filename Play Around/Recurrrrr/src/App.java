public class App {
    public static void main(String[] args) throws Exception {
        try {
        recursionDepth(1);
        } catch(Throwable e) {
            System.err.println(e.getMessage());
        }
    }
    public static int recursionDepth(int n) throws Exception {
        try {
            n++;
        return recursionDepth(n);
    } catch (StackOverflowError e) {
        n++;
        System.out.println(n);
        throw new Exception("yo, you used too much memory"); 
    }
}
}
