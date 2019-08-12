package Lesson2;

public interface Array<E> {

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

    int size();

    boolean isAmpty();

    void display();

    int createValue();

    void sortBubble();
    void sortSelect();
    void sortInsert();

}
