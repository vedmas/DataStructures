package DataStructures.Lesson3.Queue;

import DataStructures.ICollection;

public interface Queue<E> extends ICollection {

    boolean insert(E value);

    E remove();

    E peek();

}
