package DataStructures.Lesson6;

import DataStructures.ICollection;

public interface Tree<E> extends ICollection, Iterable {

    enum TraversMode{
        IN_ORDER,
        PRE_ORDER,
        POST_ORDER
    }

    boolean find(E value);
    boolean add(E value, int maxLevel);
    boolean remove(E value);
    void findFull(E value);

    void display();
    boolean isBalanced();
    int depthTree();

    void traverse(TraversMode mode);



}
