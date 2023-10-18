package class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BaekJoon10989 {
    public void solution() throws IOException {
        // BufferedReader + StringBuilder 가 가장 메모리 소모 적음
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        // Collections.sort() 사용 시 메모리 초과 문제 발생 => 제한 있을 시 기본 Arrays.sort 메서드 사용
        int a = Integer.parseInt(br.readLine());
        int[] arr = new int[a];
        for (int i = 0; i < a; i++) {
            int t = Integer.parseInt(br.readLine());
            arr[i] = t;
        }
        Arrays.sort(arr);
        for (int i = 0; i < a; i++) {
            sb.append(arr[i]).append("\n");
        }
        System.out.print(sb);
    }
}
