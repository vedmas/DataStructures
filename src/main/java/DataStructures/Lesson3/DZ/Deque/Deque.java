package DataStructures.Lesson3.DZ.Deque;

import DataStructures.ICollection;

public interface Deque<E> extends ICollection {

    boolean insertTail(E value);
    boolean insertHead(E value);
    E removeTail();
    E removeHead();
    E peekHead();
    E peekTail();
}
