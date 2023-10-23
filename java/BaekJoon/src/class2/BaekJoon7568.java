package class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 덩치
public class BaekJoon7568 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N][2];
        int[] res = new int[N];

        // 2차원배열 저장
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[i][0] = a;
            arr[i][1] = b;
        }

        // res 의 각 인덱스에 arr 요소 비교해서 몇번째로 큰지 저장
        for (int i = 0; i < N; i++) {
            int r = 1;
            for (int j = 0; j < N; j++) {
                if(arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1]) {
                    r++;
                }
            }
            res[i] = r;
        }

        for (int i = 0; i < res.length; i++) {
            if(i == res.length - 1) {
                sb.append(res[i]);
            } else {
                sb.append(res[i]).append(" ");
            }
        }
        System.out.print(sb);
    }
}
