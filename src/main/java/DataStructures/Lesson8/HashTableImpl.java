package DataStructures.Lesson8;

import java.security.Key;
import java.util.Optional;

public class HashTableImpl<K, V> implements HashTable<K, V> {

    private class Entry{
        private K key;
        private V value;

        public Entry(K key, V value) {
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
    }

    private Entry[] data;
    private int size;
    private int maxSize;

    @SuppressWarnings("unchecked")
    public HashTableImpl(int maxSize) {
        this.maxSize = maxSize;
        this.data = (Entry[]) new Object[maxSize * 2];
    }

    private int hashFunc(K key) {
        return key.hashCode() % data.length;
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

    @Override
    public boolean put(K key, V value) {
        if(isFull()) {
            return false;
        }
        int index = hashFunc(key);
        while (data[index] != null) {
            if(data[index].key.equals(key)) {
                data[index].value = value;
                return true;
            }
            index++;
            index %= data.length;
        }

        data[index] = new Entry(key, value);
        size++;
        return false;
    }

    private int indexOff(K key) {
        int index = hashFunc(key);
        while (data[index] != null) {
            if (data[index].key.equals(key)) {
                return index;
            }
            index++;
            index %= data.length;
        }
        return -1;
    }

    @Override
    public V get(K key) {
        return getEntry(key).map(entry ->
                entry.value).orElse(null);
    }

    @Override
    public V remove(K key) {
        int index = indexOff(key);
        if(index == -1) {
            return null;
        }
        V result = data[index].value;
        data[index] = null;
        size--;
        return result;
    }

    @Override
    public boolean contains(K key) {
        return get(key) != null;
    }

    private Optional<Entry> getEntry(K key) {
        int index = indexOff(key);
        if(index != -1) {
            return Optional.of(data[index]);
        }
        return Optional.empty();
    }

    @Override
    public void display() {
        System.out.println("---------------");
        for (int i = 0; i < data.length; i++) {
            System.out.printf("%d = [%s]", i, data[i]);
            System.out.println();
        }
        System.out.println("---------------");
    }
}
