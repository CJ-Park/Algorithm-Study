package class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// ATM
public class BaekJoon11399 {
    int n;
    int[] time, timeSum;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int result;
        int sum = result = 0;

        n = Integer.parseInt(br.readLine());
        time = new int[n];
        timeSum = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            time[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(time);
        for (int i = 0; i < n; i++) {
            sum += time[i];
            timeSum[i] = sum;
        }

        for (int res : timeSum) {
            result += res;
        }
        System.out.println(result);
    }
}
