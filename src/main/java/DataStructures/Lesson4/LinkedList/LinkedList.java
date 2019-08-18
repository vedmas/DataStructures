package DataStructures.Lesson4.LinkedList;

import DataStructures.ICollection;

public interface LinkedList<E> extends ICollection {

    void insertFirst(E value);

    E removeFirst();

    boolean remove(E value);

    boolean contains(E value);

    E getFirstValue();

    void display();

    class Entry<T> {
        public final T value;

        public Entry<T> next;

        public Entry(T value) {
            this.value = value;
        }
    }
}
