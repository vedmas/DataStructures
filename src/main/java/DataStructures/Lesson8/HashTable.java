package DataStructures.Lesson8;

import DataStructures.ICollection;

public interface HashTable<K, V> extends ICollection {

    boolean put(K key, V value);

    V get(K key);

    V remove(K key);

    boolean contains(K key);

    void display();

    interface Entry<K, V> {
        K getKey();
        V getValue ();
        void setKey(K key);
        void setValue(V value);
    }
}
