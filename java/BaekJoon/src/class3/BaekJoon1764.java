package class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 듣보잡
public class BaekJoon1764 {
    int n, m;
    HashSet<String> set;
    List<String> result;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        result = new ArrayList<>();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        set = new HashSet<>();

        for (int i = 0; i < n; i++) { // O(N)
            set.add(br.readLine());
        }

        for (int i = 0; i < m; i++) {
            String s = br.readLine();
            if (set.contains(s)) { // set.contains() 는 시간복잡도 O(1) / ArrayList 의 contains 는 O(N)
                result.add(s);
            }
        }

        result.sort(Comparator.naturalOrder());
        System.out.println(result.size());
        for (String res : result) System.out.println(res);
    }
}
