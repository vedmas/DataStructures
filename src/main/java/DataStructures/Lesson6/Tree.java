package DataStructures.Lesson6;

import DataStructures.ICollection;

public interface Tree<E> extends ICollection, Iterable {

    enum TraversMode{
        IN_ORDER,
        PRE_ORDER,
        POST_ORDER
    }

    boolean find(E value);
    boolean add(E value);
    boolean remove(E value);

    void display();
    boolean isBalanced();

    void traverse(TraversMode mode);



}
