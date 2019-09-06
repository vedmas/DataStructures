package DataStructures.Lesson8;

public class Main8 {
    public static void main(String[] args) {
        HashTable<Item, Integer> hashTable = new HashTableImpl<>(5);

        Item orange = new Item(1, "Orange", 150);
        Item banana = new Item(77, "Banana", 100);
        Item lemon = new Item(60, "Lemon", 250);
        Item milk = new Item(52, "Milk", 120);
        Item potato = new Item(21, "potato", 67);
        hashTable.put(orange, orange.cost);
        hashTable.put(banana, banana.cost);
        hashTable.put(lemon, lemon.cost);
        hashTable.put(milk, milk.cost);
        hashTable.put(potato, potato.cost);

        System.out.println("hashTable.size() = " + hashTable.size());
        hashTable.display();
    }
}
