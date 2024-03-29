package DataStructures.Lesson4.LinkedList;

import DataStructures.Lesson4.Iterator.ListIterator;

import java.util.Iterator;
import java.util.Objects;
import java.util.function.Consumer;

public class SimpleLinkedList<E> implements LinkedList<E> {

    protected Entry<E> firstElement;
    protected int size;

    @Override
    public void insertFirst(E value) {
        Entry<E> entry = new Entry<>(value);
        entry.next = firstElement;
        firstElement = entry;
        size++;
    }

    @Override
    public E removeFirst() {
        if (isEmpty()) {
            return null;
        }
        E value = firstElement.value;
        firstElement = firstElement.next;
        size--;
        return value;
    }

    @Override
    public boolean remove(E value) {
        Entry<E> previous = null;
        Entry<E> current = firstElement;
        while (current != null) {
            if (current.value.equals(value)) {
                break;
            }
            previous = current;
            current = current.next;
        }
        if (current == null) {
            return false;
        }
        if (current == firstElement) {
            firstElement = current.next;
        } else {
            previous.next = current.next;
        }
        size--;
        return true;
    }

    @Override
    public boolean contains(E value) {
        Entry<E> current = firstElement;
        while (current != null) {
            if (current.value.equals(value)) {
                return true;
            } else {
                current = current.next;
            }
        }
        return false;
    }

    @Override
    public void display() {
        System.out.println("--------------------");
        Entry<E> current = firstElement;
        while (current != null) {
            System.out.println(current.value);
            current = current.next;
        }
        System.out.println("--------------------");

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
        return false;
    }

    @Override
    public E getFirstValue() {
        return firstElement != null ? firstElement.value : null;
    }

    @Override
    public Iterator<E> iterator() {
        return new LinkedListIterator<E>(this);
    }

    private static class LinkedListIterator<E> implements ListIterator {

        private SimpleLinkedList list;
        private Entry<E> current;
        private Entry<E> previus;

        public LinkedListIterator(SimpleLinkedList list) {
            this.list = list;
            reset();
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Object next() {
            E nextValue = current.value;
            previus = current;
            current = current.next;
            return nextValue;
        }

        @Override
        public void reset() {
            current = list.firstElement;
            previus = null;

        }
    }
}