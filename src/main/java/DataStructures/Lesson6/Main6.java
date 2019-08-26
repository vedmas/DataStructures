package DataStructures.Lesson6;

import java.util.Random;

public class Main6 {
    public static void main(String[] args) {
        //testTree();

        for (int i = 0; i < 20; i++) {
            treeCompiler(new TreeImpl<>()).display();
        }
    }

    public static Tree<Integer> treeCompiler(Tree<Integer> tree) {
        for (int i = 0; i < 15; i++) {
            int value = (int) (Math.random() * 51) - 25;
            tree.add(value);
        }
        return tree;
    }



    public static void testTree() {
        Tree<Integer> tree = new TreeImpl<>();
        tree.add(60);
        tree.add(25);
        tree.add(66);
        tree.add(15);
        tree.add(5);
        tree.add(20);
        tree.add(45);
        tree.add(30);
        tree.add(55);
        tree.add(32);

        tree.display();
        tree.remove(30);
        tree.display();
    }
}
