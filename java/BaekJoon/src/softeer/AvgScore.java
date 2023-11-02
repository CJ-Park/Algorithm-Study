package softeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 성적 평균
public class AvgScore {
    int N, K, A, B;
    int[] S;
    String[] result;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        S = new int[N];
        result = new String[K];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            S[i] = Integer.parseInt(st.nextToken());
        }

        // 입력
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            double sum = 0;
            double count = B - A + 1;

            for (int j = A; j <= B; j++) {
                sum += S[j - 1];
            }
            double res = sum / count;
            result[i] = String.format("%.2f", res);
        }

        for (int i = 0; i < K; i++) {
            sb.append(result[i]).append("\n");
        }
        System.out.print(sb);
    }
}
