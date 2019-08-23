package DataStructures.Lesson5.DZ5;

import java.util.Objects;

public class Thing {
    String name;
    int weight;
    int price;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Thing)) return false;
        Thing thing = (Thing) o;
        return weight == thing.weight &&
                price == thing.price &&
                name.equals(thing.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, weight, price);
    }

    public Thing(String name, int weight, int price) {
        this.name = name;
        this.weight = weight;
        this.price = price;
    }

}
