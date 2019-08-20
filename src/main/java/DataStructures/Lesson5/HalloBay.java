package DataStructures.Lesson5;

public class HalloBay {
    public static void main(String[] args) {
        hallo("Huma");
    }

    private static void hallo(String name) {
        print("Hallo, " + name + "!");
        bay(name);
    }

    private static void bay(String name) {
        System.out.println("By, " + name + "!");
    }

    private static void print(String s) {
        System.out.println(s);
    }
}
