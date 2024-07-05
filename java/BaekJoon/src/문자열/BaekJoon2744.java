package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


// 브론즈5
// 대소문자 바꾸기
public class BaekJoon2744 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                c = Character.toLowerCase(c);
            } else {
                c = Character.toUpperCase(c);
            }
            result.append(c);
        }

        System.out.println(result);
    }
}
