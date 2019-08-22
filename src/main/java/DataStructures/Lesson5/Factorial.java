package DataStructures.Lesson5;

public class Factorial {

    long factorial(long n) {
        if(n <= 1) {
            return n;
        }
        n = n * factorial(n -1);
        return n;
    }
}
