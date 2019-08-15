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
    public boolean insertTail(E value) {
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
    public boolean insertHead(E value) {
        if(isFull()) {
            return false;
        }
        data[head++] = value;
        size++;
        return true;
    }

    private int lastIndex() {
        return data.length - 1;
    }

    @Override
    public E removeTail() {
        if(isEmpty()) {
            return null;
        }
        return data[--size];
    }

    @Override
    public E removeHead() {
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
    public E peekHead() {
        return isEmpty() ? null : data[head];
    }

    @Override
    public E peekTail() {
        return isEmpty() ? null : data[tail];
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
