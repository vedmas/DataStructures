package DataStructures.Lesson5;

public class Main5 {
    private static int s = 5;

    public static void main(String[] args) {
        int m = 4;
//        countDown(1);
//        Factorial factorial = new Factorial();
//        System.out.println(factorial.factorial(5));
        getAnagram(4);
    }

    private static void countDown(int n) {

        System.out.println("n = " + n);
        if (n < 3) {
            countDown(++n);
        }
        System.out.println("n = " + n);
        //System.out.println(s + n);
    }

    private static void getAnagram(int lenght) {   // запустили метод с параметром 4 кол-во букв в слове
        if (lenght == 1) {
            return;
        }
        System.out.println("lenght = " + lenght);
        System.out.println("--------------------------");
        for (int i = 0; i < lenght; i++) {
            getAnagram(lenght - 1);
            System.out.println("lenghtPostGet = " + lenght);
        }
    }
}
