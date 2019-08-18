package DataStructures.Lesson4.LinkedList;

import DataStructures.Lesson3.Stack.Stack;

public class LinkedStackImpl<E> implements Stack<E> {

    private LinkedList<E> data;

    public LinkedStackImpl() {
        this.data = new SimpleLinkedList<>();
    }

    @Override
    public void push(E value) {
        data.insertFirst(value);

    }

    @Override
    public E pop() {
        return data.removeFirst();
    }

    @Override
    public E peek() {
        return data.getFirstValue();
    }

    @Override
    public int size() {
        return data.size();
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    @Override
    public boolean isFull() {
        return false;
    }
}
