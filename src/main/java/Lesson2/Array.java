package Lesson2;

public interface Array<E> {

    void add(E value);

    void addAll(E ... value);

    boolean remove(E... value);

    boolean remove(int index);

    E get(int index);

    boolean contains(E values);

    int indexOf(E value);

    int size();

    boolean isAmpty();
}
