package class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

// 잃어버린 괄호 - 그리디 + 문자열 파싱 (정규식 표현)
public class BaekJoon1541 {
    ArrayList<Integer> numbers = new ArrayList<>();
    int result;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split("-");
        for (String s1 : s) {
            int sum = 0;
            String[] split = s1.split("\\+"); // +, *, ^ 등은 정규식 표현 시 \\ 붙여줘야 됨
            for (String num : split) {
                sum += Integer.parseInt(num);
            }
            numbers.add(sum);
        }

        result = numbers.get(0);

        for (int i = 1; i < numbers.size(); i++) {
            result -= numbers.get(i);
        }
        System.out.println(result);
    }
}
