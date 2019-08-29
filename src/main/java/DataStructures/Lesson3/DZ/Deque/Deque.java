package DataStructures.Lesson3.DZ.Deque;

import DataStructures.ICollection;

public interface Deque<E> extends ICollection {

    boolean insertRight(E value);
    boolean insertLeft(E value);
    E removeRight();
    E removeLeft();
    E peek();
}
