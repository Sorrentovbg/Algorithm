package lesson6;


public class Test6 {

    public static void main(String[] args) {
        Tree<Integer> treeOne = new TreeImpl<>();
        Tree<Integer> treeTwo = new TreeImpl<>();
        Tree<Integer> treeThree = new TreeImpl<>();
        Tree<Integer> treeFour = new TreeImpl<>();

        fillTree(treeOne);
        fillTree(treeTwo);
        fillTree(treeThree);
        fillTree(treeFour);

        treeOne.display();
        System.out.println("-----------------------------------");
        treeTwo.display();
        System.out.println("-----------------------------------");
        treeThree.display();
        System.out.println("-----------------------------------");
        treeFour.display();

//        tree.display();
//        tree.remove(40);
//        tree.display();

        treeOne.traverse(Tree.TraverseMode.IN_ORDER);
        treeTwo.traverse(Tree.TraverseMode.IN_ORDER);
        treeThree.traverse(Tree.TraverseMode.IN_ORDER);
        treeFour.traverse(Tree.TraverseMode.IN_ORDER);
//        treeOne.traverse(Tree.TraverseMode.PRE_ORDER);
//        treeTwo.traverse(Tree.TraverseMode.POST_ORDER);

    }

    private static void fillTree (Tree<Integer> tree) {
        int size = 63;
        int min = -25;
        int max = 25;
        for(int i = 0; i <= size; i++){
            int number = min + (int)(Math.random() * ((max - min) + 1));
            tree.add(number);
        }
    }

}
