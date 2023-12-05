public class binaryDriver {
    public static void main(String[] args) {
        BinaryTree<String> tree = new BinaryTree<String>();
        tree.add("sus", "");
        tree.add("soo", "L");
        tree.add("f", "R");
        tree.add("among", "LR");
        tree.add("us", "RL");
        System.out.println(tree.counthelper());
        BinarySearchTree<String> Bintree = new BinarySearchTree<String>();
        Bintree.add("sus");
        Bintree.add("soo");
        Bintree.add("f");
        Bintree.add("among");
        Bintree.add("us");
        Bintree.add("ru");
        System.out.println(Bintree.counthelper());
        System.out.println(Bintree.countSmaller("us"));
        /*1. Write a method called count that is part of the BinaryTree<E> class that
         returns the number of nodes in the tree (without returning numElt or numberOfElements;
         calculate it by going through the tree). You'll want to write a countRecursive helper method
        that does most of the work.

2. Write a method called countSmaller(E x) that is part of the BinarySearchTree<E> class
 that returns the number of values stored in the tree that are smaller than x (according to compareTo). 
 For example, if the tree stored the letters A, C, G, J, K, Q, Z, countSmaller(H) would return 3,
  as would countSmaller(G) and countSmaller(I). Note that x may or may not be a value in the tree; 
  your code should work either way. 
  Again you'll want a countSmallerRecursive method that does most of the work. 
  Your method must do the minimum amount of work possible. 
  Hint: The countRecursive method you wrote for part 1 might be useful here. */
    }
}
