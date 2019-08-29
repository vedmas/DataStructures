package DataStructures.Lesson6;

public class Main6 {
    public static void main(String[] args) {
        //testTree();
        treeCreator(20);
    }

    private static void treeCreator(int numbersOfTree) {
        double balancedTree = 0.0;
        for (int i = 0; i < numbersOfTree; i++) {
            Tree<Integer> tree = treeCompiler(new TreeImpl<>(4));
            tree.display();
//            tree.traverse(Tree.TraversMode.PRE_ORDER);
            System.out.println("tree is balanced = " + tree.isBalanced());
            if(tree.isBalanced()) {
                balancedTree++;
            }
        }
        System.out.println("balancedTree = " + balancedTree);
        System.out.println("Доля сбалансированных деревьев " + ((balancedTree / numbersOfTree) * 100) + "%");
    }

    private static Tree<Integer> treeCompiler(Tree<Integer> tree) {
        for (int i = 0; i < 15; i++) {
            int value = (int) (Math.random() * 51) - 25;
            tree.add(value);
        }
        return tree;
    }


    public static void testTree() {
        Tree<Integer> tree = new TreeImpl<>(4);
        System.out.println(tree.add(60));
        System.out.println(tree.add(50));
        System.out.println(tree.add(40));
        System.out.println(tree.add(55));
        System.out.println(tree.add(66));
        System.out.println(tree.add(56));
        System.out.println(tree.add(72));
        System.out.println(tree.add(30));
        System.out.println(tree.add(55));
        System.out.println(tree.add(83));
        System.out.println(tree.add(20));
        System.out.println(tree.add(25));
        System.out.println(tree.add(51));
        System.out.println(tree.add(41));
        tree.display();
        tree.traverse(Tree.TraversMode.PRE_ORDER);
        System.out.println("tree is balanced? = " + tree.isBalanced());
    }
    }
