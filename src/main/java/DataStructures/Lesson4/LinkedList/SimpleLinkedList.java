package DataStructures.Lesson4.LinkedList;

public class SimpleLinkedList<E> implements LinkedList<E> {

    private Entry<E> firsElement;
    private int size;

    @Override
    public void insertFirst(E value) {
        Entry<E> entry = new Entry<>(value);
        entry.next = firsElement;
        firsElement = entry;
        size++;

    }

    @Override
    public E removeFirst() {
        if(isEmpty()) {
            return null;
        }
        E value = firsElement.value;
        firsElement = firsElement.next;
        size--;
        return value;
    }

    @Override
    public boolean remove(E value) {
        Entry<E> previous = null;
        Entry<E> current = firsElement;
        while (current != null) {
            if (current.value.equals(value)) {
                break;
            }
            previous = current;
            current = current.next;
        }
            if(current == null){
                return false;
            }
            if(current == firsElement) {
                firsElement = current.next;
            } else {
                previous.next = current.next;
            }
        size--;
        return true;
    }

    @Override
    public boolean contains(E value) {
        Entry<E> current = firsElement;
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
        Entry<E> current = firsElement;
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
        return firsElement != null ? firsElement.value : null;
    }
}
