import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

// 에디터 - 시간초과 발생 -> 다시풀기
public class BaekJoon1406 {
    String words;
    int now;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        words = br.readLine();
        now = words.length();
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            edit(s);
        }
        System.out.println(words);
    }

    public void edit(String[] s) {
        String editor = s[0];
        if (Objects.equals(editor, "L") && now != 0) {
            now--;
        }
        if (Objects.equals(editor, "D") && now != words.length()) {
            now++;
        }
        if (Objects.equals(editor, "B") && now != 0) {
            String s1 = words.substring(0, now - 1);
            String s2 = words.substring(now);
            words = s1 + s2;
            now--;
        }
        if (Objects.equals(editor, "P")) {
            String ch = s[1];
            String s1 = words.substring(0, now);
            String s2 = words.substring(now);
            words = s1 + ch + s2;
            now++;
        }
    }
}
