package Graph.level3;

import java.util.*;
import java.util.Queue;
import java.util.stream.Collectors;

public class 단어변환 {

    static class Word {
        int count;
        String word;

        public Word(int n, String s) {
            this.count = n;
            this.word = s;
        }
    }

    static Queue<Word> queue = new ArrayDeque<>();
    static List<String> list = new ArrayList<>();

    public static int solution(String begin, String target, String[] words) {
        int result = -1;

        list = Arrays.stream(words).collect(Collectors.toList());
        queue.add(new Word(0, begin));

        while (!queue.isEmpty()) {
            Word w = queue.poll();
            System.out.println(w.word);
            if (w.word.equals(target)) {
                result = w.count;
                break;
            }

            checkWord(w, words.length);
        }

        if (result == -1) {
            result = 0;
        }

        return result;
    }

    public static void checkWord(Word w, int size) {
        if (w.count == size || list.isEmpty()) {
            return;
        }

        list.remove(w.word);

        for (String word : list) {
            int counter = 0;

            for (int i = 0; i < w.word.length(); i++) {
                if (word.charAt(i) != w.word.charAt(i)) {
                    counter++;
                }
            }

            if (counter == 1) {
                queue.add(new Word(w.count + 1, word));
            }
        }
    }
}
