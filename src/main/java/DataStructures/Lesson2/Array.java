package DataStructures.Lesson2;

import DataStructures.ICollection;

public interface Array<E> extends ICollection {

    void add(E value);

    default void addAll(E ... values) {
        for (E value : values) {
            add(value);
        }
    }

    boolean remove(E value);

    boolean remove(int index);

    E get(int index);

    boolean contains(E values);

    int indexOf(E value);

    void display();

    int createValue();

    void sortBubble();
    void sortSelect();
    void sortInsert();

}
