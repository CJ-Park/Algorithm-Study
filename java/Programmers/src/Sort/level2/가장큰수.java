package Sort.level2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class 가장큰수 {

    // stream 문법 사용
    // collect(Collectors.toList()) 문법 사용 시 별도의 import 필요
    // => java.util.*; 로는 java.util.stream 의 하위패키지에 접근 불가
    public String solution_1(int[] numbers) {
        StringBuilder sb = new StringBuilder();

        List<String> list = Arrays.stream(numbers)
                .mapToObj(String::valueOf)
                .sorted((s1, s2) -> (s2 + s1).compareTo(s1 + s2))
                .collect(Collectors.toList());

        if (list.get(0).equals("0")) {
            return "0";
        }

        for (String s : list) {
            sb.append(s);
        }
        return sb.toString();
    }

    public String solution_2(int[] numbers) {
        StringBuilder sb = new StringBuilder();
        String[] list = new String[numbers.length];

        for (int i = 0; i < list.length; i++) {
            list[i] = String.valueOf(numbers[i]);
        }

        // s1 s2 / 200 2 -> 2002 / 2200
        // 0 200 -> 0200 / 2000
        Arrays.sort(list, (s1, s2) -> (s2 + s1).compareTo(s1 + s2));

        for (String s : list) {
            sb.append(s);
        }

        return sb.substring(0, 1).equals("0") ? "0" : sb.toString();
    }
}
