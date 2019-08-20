package DataStructures.Lesson5;

public class Main5 {
    public static void main(String[] args) {
        countDown(1);
    }

    private static void countDown(int n) {
        System.out.println("n = " + n);
        if(n <10) {
            countDown(++n);
        }

    }
}
