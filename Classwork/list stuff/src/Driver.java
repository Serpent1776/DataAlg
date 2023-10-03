import DSListStuff.*;
public class Driver {
    public static void main(String[] args) throws Exception {
        try {
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
        /*DSArrayList<Integer> Dominos = new DSArrayList<Integer>();
        Integer[] arr = {6, 5, 1, 5, 2, 3, 1, 5, 1};
        Dominos.add(arr);
        /*Topping pepperoni = new Topping("pepperoni", 6);
        Topping ham = new Topping("ham", 5);
        Topping pineapple = new Topping("pineapple", 7);
        Topping mushroom = new Topping("mushroom", 10);
        Topping meatball = new Topping("meatball", 3);
        Topping[] smol = {pepperoni};
        Pizza small = new Pizza(8, smol, 6.0, true, true);
        Topping[] frozen = {ham, pineapple};
        Pizza frozenOne = new Pizza(8, frozen, 15.0, false, true);
        Topping[] noToppings = {};
        Pizza large = new Pizza(10, noToppings, 16.0,true, true);
        Topping[]supreme = {pepperoni, mushroom, meatball, ham};
        Pizza basement = new Pizza(10, supreme, 15.0, true, false);
        Pizza eaten = new Pizza(0, noToppings, 0, false, false);
        Dominos.add(eaten);
        System.out.println(Dominos);
        Pizza[] pizzas = {small, frozenOne, large};
        Dominos.add(pizzas);
        System.out.println(Dominos);
        Dominos.addSorted(basement);
        System.out.println(Dominos);
        Dominos.remove(eaten);
        System.out.println(Dominos.getMode()); /* */
        DSLinkedList<Integer> PizzaHut = new DSLinkedList<Integer>();
        //  rotating 'r','u','t','a','b','a','g','a' gives the list 'u', 't', 'a', 'b', 'a', 'g', 'a', 'r'. 
        //[6, 5, 1, 5, 2, 3, 1, 5, 1]
        PizzaHut.addtoFront(1);
        PizzaHut.addtoFront(5);
        PizzaHut.addtoFront(1);
        PizzaHut.addtoFront(3);
        PizzaHut.addtoFront(2);
        PizzaHut.addtoFront(5);
        PizzaHut.addtoFront(1);
        PizzaHut.addtoFront(5);
        PizzaHut.addtoFront(6);
        System.out.println(PizzaHut.getMode()); /* */
        DSLinkedList<String> PizzaHut2 = new DSLinkedList<String>();
        //  rotating 'r','u','t','a','b','a','g','a' gives the list 'u', 't', 'a', 'b', 'a', 'g', 'a', 'r'. 
        PizzaHut2.addtoFront("r");
        PizzaHut2.add("u");
        PizzaHut2.add("t");
        PizzaHut2.add("a");
        PizzaHut2.add("b");
        PizzaHut2.add("a");
        PizzaHut2.add("g");
        PizzaHut2.add("a");
        //System.out.println(PizzaHut2);
        PizzaHut2.rotate();
        //PizzaHut.remove(0);
        //System.out.println(PizzaHut2);
    } catch(Exception e) {
        System.out.println(e);
    }
    }
}
