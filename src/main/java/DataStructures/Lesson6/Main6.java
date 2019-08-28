package DataStructures.Lesson6;

import java.util.Random;

public class Main6 {
    public static void main(String[] args) {
//        testTree();

        for (int i = 0; i < 1; i++) {
            Tree<Integer> tree = treeCompiler(new TreeImpl<>());
            tree.display();
            tree.traverse(Tree.TraversMode.PRE_ORDER);
        }
    }

    private static Tree<Integer> treeCompiler(Tree<Integer> tree) {
        for (int i = 0; i < 15; i++) {
            int value = (int) (Math.random() * 51) - 25;
            tree.add(value, 4);
        }
        return tree;
    }


//    public static void testTree() {
//        Tree<Integer> tree = new TreeImpl<>();
//        tree.add(60, 4);
//        tree.add(50, 4);
//        tree.add(40);
//        tree.add(55);
//        tree.add(66);
//        tree.add(56);
//        tree.add(72);
//        tree.add(30);
//        tree.add(55);
//        tree.add(83);

//        tree.display();
//        tree.remove(30);
//        tree.display();
//        tree.traverse(Tree.TraversMode.PRE_ORDER);
//        tree.findFull(55);
//        System.out.println("depth = " + tree.depthTree());
//        System.out.println("tree.find(72) = " + tree.find(72));
    }
