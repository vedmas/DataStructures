package Lesson2;

import java.util.Arrays;

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
        checkGrow();
        data[size++] = value;
    }

    private void checkGrow() {
        if(size == data.length) {
            this.data = grow();
        }
    }

    private E[] grow() {
        return Arrays.copyOf(data, data.length * 2);
    }

    @Override
    public boolean remove(E... value) {
        return false;
    }

    @Override
    public boolean remove(int index) {
        if(index < -1 || index >= size) {
            return false;
        }

        for (int i = index; i < size - 1 ; i++) {
            data[i] = data[i + 1];
        }
        data[--size - 1] = null;
        return true;
    }

    @Override
    public E get(int index) {
        if(index > 0 && index < size) {
            return data[index];
        }
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
        return size;
    }

    @Override
    public boolean isAmpty() {
        return size == 0;
    }
}
