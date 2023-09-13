public class App {
    public static void main(String[] args) throws Exception {
        /* DSArrayList<String> str = new DSArrayList<String>();
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
         */
        DSArrayList<Pizza> Dominos = new DSArrayList<Pizza>();
        Pizza small = new Pizza(8, 6.0, true, true);
        Pizza frozenOne = new Pizza(8, 15.0, false, true);
        Pizza large = new Pizza(10,16.0,true, true);
        Pizza basement = new Pizza(10, 15.0, true, false);
        Pizza eaten = new Pizza(0, 0, false, false);
        Dominos.add(eaten);
        System.out.println(Dominos);
        Pizza[] pizzas = {small, frozenOne, large};
        Dominos.add(pizzas);
        System.out.println(Dominos);
        Dominos.addSorted(basement);
        System.out.println(Dominos);
    }
}
