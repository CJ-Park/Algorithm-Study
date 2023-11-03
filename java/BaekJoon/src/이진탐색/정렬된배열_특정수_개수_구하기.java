package 이진탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 정렬된배열_특정수_개수_구하기 {
    int n, x, count;
    int[] arr;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int idx = searchValue();
        if (idx != -1) {
            while (arr[idx] == x) {
                idx++;
                count++;
            }
            System.out.println(count);
        } else {
            System.out.println(idx);
        }
    }

    public int searchValue() {
        int left = 0;
        int right = arr.length - 1;
        int res = 0;
        while (left <= right) {
            int mid = (left + right) / 2;

            if (arr[mid] >= x) {
                res = mid;
                right = mid - 1;
            } else if (arr[mid] < x) {
                left = mid + 1;
            } else {
                res = -1;
            }
        }
        return res;
    }
}
