package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 설탕배달
public class BaekJoon2839 {
    int n, count;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        // 최소 개수의 봉지 -> 5kg 짜리 최대한 가져가야됨
        // n 을 5로 나눠서 나눠지면 count 에 몫 더하기
        // 안나눠지면 n -= 3 / count++

        while (n > 0) {
            if (n % 5 == 0) {
                count += n / 5;
                n = 0;
                break;
            } else {
                n -= 3;
                count++;
            }
        }

        if (n < 0) {
            System.out.println(-1);
        } else {
            System.out.println(count);
        }
    }
}
