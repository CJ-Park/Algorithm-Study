package 정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/*
보물 - 실버4
 */
public class BaekJoon1026 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        List<Integer>[] arr = new List[2];

        for (int i = 0; i < 2; i++) {
            arr[i] = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i].add(Integer.parseInt(st.nextToken()));
            }
        }

        Collections.sort(arr[0]);
        Collections.sort(arr[1], Collections.reverseOrder());

        int result = 0;
        for (int i = 0; i < n; i++) {
            result += arr[0].get(i) * arr[1].get(i);
        }

        System.out.print(result);
    }
}
