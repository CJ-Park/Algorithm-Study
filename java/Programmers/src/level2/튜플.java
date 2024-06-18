package level2;

import java.util.Arrays;
import java.util.Comparator;

// 2019 카카오 겨울 인턴십
public class 튜플 {
    public int[] solution(String s) {
        // 문자열을 어떻게 숫자배열로 바꿀것인가

        s = s.substring(2, s.length() - 2);
        // s - "2},{2,1},{2,1,3},{2,1,3,4"

        String[] str = s.split("\\},\\{");
        // str - ["2", "2,1", "2,1,3", "2,1,3,4"]

        // 문자의 길이순으로 정렬
        Arrays.sort(str, Comparator.comparingInt(String::length));

        boolean[] number = new boolean[100001];
        int[] result = new int[str.length];

        for (int i = 0; i < str.length; i++) {
            String[] numList = str[i].split(",");

            for (String num : numList) {
                if (!number[Integer.parseInt(num)]) { // 저장이 안된 숫자일 경우
                    int idx = Integer.parseInt(num);
                    number[idx] = true;
                    result[i] = idx;
                }
            }
        }

        return result;
    }
}
