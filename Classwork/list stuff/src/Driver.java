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
        DSArrayList<Pizza> Dominos = new DSArrayList<Pizza>(1);
        Topping pepperoni = new Topping("pepperoni", 6);
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
        /*Dominos.add(eaten);
        System.out.println(Dominos);
        Pizza[] pizzas = {small, frozenOne, large};
        Dominos.add(pizzas);
        System.out.println(Dominos);
        Dominos.addSorted(basement);
        System.out.println(Dominos);
        Dominos.remove(eaten);
        System.out.println(Dominos);*/
        DSLinkedList<Integer> PizzaHut = new DSLinkedList<Integer>();
        //  rotating 'r','u','t','a','b','a','g','a' gives the list 'u', 't', 'a', 'b', 'a', 'g', 'a', 'r'. 
        PizzaHut.addtoFront(5);
        PizzaHut.addtoFront(4);
        PizzaHut.addtoFront(5);
        PizzaHut.addtoFront(2);
        PizzaHut.addtoFront(1);
        PizzaHut.addSorted(0);
        DSLinkedList<Integer> PizzaHut2 = new DSLinkedList<Integer>();
        //  rotating 'r','u','t','a','b','a','g','a' gives the list 'u', 't', 'a', 'b', 'a', 'g', 'a', 'r'. 
        /*PizzaHut2.addtoFront(5);
        PizzaHut2.addtoFront(4);
        PizzaHut2.addtoFront(5);
        PizzaHut2.addtoFront(2);
        PizzaHut2.addtoFront(1);
        PizzaHut2.addSorted(100);*/
        PizzaHut.rotate();
        System.out.println(PizzaHut);
    } catch(Exception e) {
        System.out.println(e);
    }
    }
}
