package DataStructures.Lesson3.DZ.Deque;

public class DequeImpl<E> implements Deque<E> {

    private static final int DEFAULT_HEAD = 0;
    private static final int DEFAULT_TAIL = -1;

    protected int size, head, tail;
    protected final E[] data;


    @SuppressWarnings("unchecked")
    public DequeImpl(int maxCapacity) {
        this.data = (E[]) new Object[maxCapacity];
        this.head = DEFAULT_HEAD;
        this.tail = DEFAULT_TAIL;
    }

    @Override
    public boolean insertRight(E value) {
        if(isFull()) {
            return false;
        }
        if(tail == lastIndex()) {
            tail = DEFAULT_TAIL;
        }
        data[++tail] = value;
        size++;
        return true;
    }

    //Вставка в начало очереди
    @Override
    public boolean insertLeft(E value) {
        if(isFull()) {
            return false;
        }
        if(head == 0) {
            head = data.length;
        }
        data[--head] = value;
        size++;
        return true;
    }

    private int lastIndex() {
        return data.length - 1;
    }

    @Override
    public E removeRight() {
        if(isEmpty()) {
            return null;
        }
        return data[--size];
    }

    @Override
    public E removeLeft() {
        if(isEmpty()) {
            return null;
        }
        if(head == data.length) {
            head = DEFAULT_HEAD;
        }
        E value = data[head++];
        size--;

        return value;
    }

    @Override
    public E peek() {
        return data[head];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return data.length == size;
    }
}
