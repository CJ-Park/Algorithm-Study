package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 브론즈2
// 애너그램 만들기
// replaceFirst 메소드 사용
public class BaekJoon1919 {
    // 두 문자열 비교해서 안겹치는 문자 개수 구하기
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1, s2;
        int result = 0;

        s1 = br.readLine();
        s2 = br.readLine();

        char[] c = s1.toCharArray();

        for (int i = 0; i < c.length; i++) {
            String s = String.valueOf(c[i]);
            if (s2.contains(s)) {
                s2 = s2.replaceFirst(s, "");
            } else {
                result++;
            }
        }

        result += s2.length();

        System.out.println(result);
    }
}
