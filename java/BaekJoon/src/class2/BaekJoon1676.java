package class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 팩토리얼 결과값 0의 개수
public class BaekJoon1676 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int count = 0;
        long res = 1;
        // N! 이므로 1부터 N까지 곱해가면서 마지막자리 0이 나오면 count 올리고 10 나눠줌
        for (int i = 1; i <= N; i++) {
            res *= i;
            if(res % 10 == 0) {
                while(res % 10 == 0) {
                    res /= 10;
                    count++;
                }
            }
            // 2 * 5 의 값들은 이미 위에서 정리 끝냈기 때문에 1000 이상으로 나눈 나머지만 남겨 오버플로우 안나도록 함
            res = res % 10000;
        }
        sb.append(count);
        System.out.print(sb);
    }
}
