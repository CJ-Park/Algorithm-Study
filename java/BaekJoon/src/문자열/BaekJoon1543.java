package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 문서 검색
public class BaekJoon1543 {

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        String search = br.readLine();

        int count = countSearch(input, search);
        System.out.println(count);
    }

    // split 의 시간 복잡도 O(n)
    private int countSearch(String input, String search) {
        input = " " + input + " ";
        String[] split = input.split(search);
        return split.length - 1;
    }
}
