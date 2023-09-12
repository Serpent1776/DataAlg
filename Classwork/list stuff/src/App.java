public class App {
    public static void main(String[] args) throws Exception {
        DSArrayList<String> str = new DSArrayList<String>();
        DSArrayList<String> str2 = str;
        DSArrayList<String> str3 = new DSArrayList<String>();
        String as = "a";
        for(int i = 0; i < 10; i++) {
            str.add(as);
            as += 'b';
        }
        as = "a";
        for(int i = 0; i < 10; i++) {
            str3.add(as);
            as += 'a';
        }
        System.out.println(str);
        str.addSorted("ab");
        System.out.println(str.equals(str3));
        System.out.println(str);
        str.rotate();
        System.out.println(str);
        System.out.println(str.equals(str2));
        System.out.println(str.allIndices("a"));
        str.clear();
        System.out.println(str);
    }
}
