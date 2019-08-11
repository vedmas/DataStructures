package Lesson2;

public class ArrayOperation <E>  implements Array <E>{

    private static final int DEFAULT_CAPACITY = 16;

    private E [] data;
    private int size;

    @SuppressWarnings("unchecked")
    public ArrayOperation() {
        this.data = (E[]) new Object [DEFAULT_CAPACITY];
    }

    @Override
    public void add(E value) {

    }

    @Override
    public void addAll(E... value) {

    }

    @Override
    public boolean remove(E... value) {
        return false;
    }

    @Override
    public boolean remove(int index) {
        return false;
    }

    @Override
    public E get(int index) {
        return null;
    }

    @Override
    public boolean contains(E values) {
        return false;
    }

    @Override
    public int indexOf(E value) {
        return 0;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isAmpty() {
        return false;
    }
}
