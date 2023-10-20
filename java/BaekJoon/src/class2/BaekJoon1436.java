package class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 영화감독 숌
public class BaekJoon1436 {
    // 666이 들어가는 N 번째로 작은 수 찾기
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int i = 666;
        int index = 0;
        while (arr[N - 1] == 0) {
            String s = String.valueOf(i);
            if (s.contains("666")) {
                arr[index] = Integer.parseInt(s);
                index++;
            }
            i++;
        }
        sb.append(arr[N - 1]);
        System.out.print(sb);
    }
}
