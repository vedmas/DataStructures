package DataStructures.Lesson8;

import java.util.Objects;

public class Item {

    public final int id;
    public String name;
    public int cost;

    public Item(int id, String name, int cost) {
        this.id = id;
        this.name = name;
        this.cost = cost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return id == item.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
