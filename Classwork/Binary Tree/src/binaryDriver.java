public class binaryDriver {
    public static void main(String[] args) {
        BinaryTree<String> tree = new BinaryTree<String>();
        tree.add("sus", "");
        tree.add("soo", "L");
        tree.add("f", "R");
        tree.add("among", "LR");
        tree.add("us", "RL");
        System.out.print(tree);
    }
}
