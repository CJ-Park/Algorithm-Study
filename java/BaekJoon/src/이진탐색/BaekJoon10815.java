package 이진탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
숫자 카드
이진탐색 안써도 풀리긴 함
 */
public class BaekJoon10815 {
    static int CENTER = 10_000_000;
    static boolean[] haveCard = new boolean[2 * CENTER + 1];

    // 1. 이진탐색 없이 푼거
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n, m;

        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int idx = Integer.parseInt(st.nextToken()) + CENTER;
            haveCard[idx] = true;
        }

        StringBuilder sb = new StringBuilder();
        m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int idx = Integer.parseInt(st.nextToken());

            if (haveCard[idx + CENTER]) {
                sb.append(1).append(" ");
            } else {
                sb.append(0).append(" ");
            }
        }

        System.out.println(sb);
    }

    // 2. 이진탐색으로 푼거
    public void solution_2() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n, m;

        n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // -10 2 3 6 10
        Arrays.sort(arr);

        StringBuilder sb = new StringBuilder();
        m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int val = Integer.parseInt(st.nextToken());

            if (bs(arr, val)) {
                sb.append(1).append(" ");
            } else {
                sb.append(0).append(" ");
            }
        }

        System.out.println(sb);
    }

    private boolean bs(int[] arr, int val) {
        int i = 0;
        int j = arr.length - 1;

        while (i <= j) {
            int mid = (i + j) / 2;

            if (arr[mid] > val) {
                j = mid - 1;
            } else if (arr[mid] < val) {
                i = mid + 1;
            } else
                return true;
        }

        return false;
    }
}
