package class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

// 단어 정렬
public class BaekJoon1181 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<String> words = new ArrayList<>();

        // 0. words 에 단어 때려박기
        for (int i = 0; i < N; i++) {
            words.add(br.readLine());
        }

        // 1. 사전 순 정렬
        words.sort(Comparator.naturalOrder());

        // 1-1. 길이 순 정렬 -> 버블정렬 사용
        for (int i = 0; i < words.size() - 1; i++) {
            for (int j = 0; j < words.size() - (i + 1); j++) {
                if (words.get(j).length() > words.get(j + 1).length()) {
                    String tmp = words.get(j);
                    words.set(j, words.get(j + 1));
                    words.set(j + 1, tmp);
                }
            }
        }

        // 2. 중복 제거
        for (int i = 0; i < words.size() - 1; i++) {
            if (Objects.equals(words.get(i), words.get(i + 1))) {
                words.remove(i + 1);
                i--;
            }
        }

        for (String word : words) {
            System.out.println(word);
        }
    }
}
