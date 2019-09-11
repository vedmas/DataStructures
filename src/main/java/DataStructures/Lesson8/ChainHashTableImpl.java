package DataStructures.Lesson8;
import java.util.LinkedList;

public class ChainHashTableImpl<K, V> implements HashTable<K, V> {

    private static class Node<K, V> implements Entry<K, V> {
        private K key;
        private V value;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Entry{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public void setKey(K key) {
            this.key = key;
        }

        @Override
        public void setValue(V value) {
            this.value = value;
        }
    }

    private LinkedList<Node<K, V>>[] data;
    private int size;
    private int maxSize;

    @SuppressWarnings("unchecked")
    ChainHashTableImpl(int maxSize) {
        this.maxSize = maxSize;
        this.data = new LinkedList[maxSize * 2];
    }

    private int hashFunc(K key) {
        return key.hashCode() % data.length;
    }

    @Override
    public boolean put(K key, V value) {
        if(isFull()) {
            return false;
        }
        int index = hashFunc(key);
        if(data[index] == null) {
            data[index] = new LinkedList<>();
        }
        Node<K, V> node = new Node<>(key, value);
        data[index].add(node);
            size++;
        return true;
    }

    @Override
    public V get(K key) {

        return null;
    }

    @Override
    public V remove(K key) {
        if(isEmpty()) {
            return null;
        }
        int index = hashFunc(key);
        for (int i = 0; i < data.length; i++) {
            if(i == index && data[i] != null) {
                for (Node<K, V> nodeElement : data[i]) {
                    if(nodeElement.key.equals(key)) {
                        data[i].remove(nodeElement);
                       return nodeElement.value;
                    }
                }
            }
        }

        return null;
    }

    @Override
    public boolean contains(K key) {
        return false;
    }

    @Override
    public void display() {
        System.out.println("-------------------");
        for (int i = 0; i < data.length; i++) {
            System.out.printf("%d = [%s]", i, data[i]);
            System.out.println();
        }
        System.out.println("-------------------");
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
        return size == maxSize;
    }
}
