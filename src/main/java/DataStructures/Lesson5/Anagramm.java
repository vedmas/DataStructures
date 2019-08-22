package DataStructures.Lesson5;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Anagramm {
    public static void main(String[] args) {
        new Anagramm("pack").getAnagram();
    }

    private char[] word;
    private List<String> result = new ArrayList<>();

    public Anagramm(String word) {
        this.word = word.toCharArray();
    }

    public void getAnagram() {
        if(word.length < 2) {
            System.out.println(String.valueOf(word));
            return;
        }
        getAnagram(word.length);
        for (String anagram : result) {
            System.out.println(anagram);
        }
    }

    private void getAnagram(int lenght) {   // запустили метод с параметром 4 кол-во букв в слове
        if(lenght == 1) {
            return;
        }
        for (int i = 0; i < lenght; i++) {
            getAnagram(lenght - 1);
            result.add(String.valueOf(word));
            rotate(lenght); //3
        }
    }
// циклическое перемещение символов
    private void rotate(int lenght) { //3
        int pos = word.length - lenght; // 4 - 3 = 1
        char temp = word[pos]; // temp = a
        for (int i = pos + 1; i < word.length; i++) { //i = 1 + 1 = 2
        word[i - 1] = word[i]; // word[2 - 1] = word[2]
        }
        word[word.length - 1] = temp;
    }
}
