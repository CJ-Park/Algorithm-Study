package 시뮬레이션;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// iSharp - 실버3
public class BaekJoon3568 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();
        String[] input = br.readLine().split(" ");

        String prefix = input[0]; // 공통 선언 부분

        for (int i = 1; i < input.length; i++) {
            char[] arr = input[i].toCharArray();

            // abc*[]&,
            // abc / *[]& / , => abc / &][* / ,
            // abc / &[]* / , => abc / &[]* / ; => prefix / &[]* / abc / ;
            int start = 0;
            for (int j = 0; j < arr.length; j++) {
                if (!Character.isAlphabetic(arr[j])) {
                    start = j;
                    break;
                }
            }

            // 변수 추출
            String varName = input[i].substring(0, start);

            // 변수타입 뒤집기
            StringBuilder sb = new StringBuilder();
            for (int j = start; j < arr.length - 1; j++) {
                sb.append(arr[j]);
            }
            String type = sb.reverse().toString();

            // 뒤집힌 [] 순서 바꾸기
            type = type.replaceAll("]\\[", "[]");

            String str = prefix + type + " " + varName + arr[arr.length - 1];
            str = str.replace(",", ";");

            result.append(str).append("\n");
        }

        System.out.println(result);
    }
}
