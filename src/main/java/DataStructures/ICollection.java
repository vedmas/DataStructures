package DataStructures;

public interface ICollection {

    int size();

    boolean isEmpty();

    default boolean isFull() {
        return false;
    }
}
