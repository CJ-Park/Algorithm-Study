package class4.restudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

// 평범한 배낭 - dp 문제
public class BaekJoon12865 {
    int n, maxWeight;
    int[][] dp;
    List<Item> itemList = new ArrayList<>();

    // 이진탐색 dfs 사용 -> 2^100 의 시간복잡도 가지므로 시간초과
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        maxWeight = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            itemList.add(new Item(weight, value));
        }

        itemList.sort(Comparator.naturalOrder());
        dp = new int[itemList.size() + 1][maxWeight + 1];

        //       0  1  2  3  4  5  6  7
        //  0    0  0  0  0  0  0  0  0
        //  1(3) 0  0  0  6  6  6  6  6
        //  2(4) 0  0  0  6  8  8  8 8+6
        //  3(5) 0  0  0  6  8  12 12 14
        //  4(6) 0  0  0  6  8  12 13 14

        // 무게가 중복되는 경우도 있음
        //       0  1  2  3  4  5  6  7
        //  0    0  0  0  0  0  0  0  0
        //  1(1) 0  1  1  1  1  1  1  1
        //  2(1) 0  1  2  2  2  2  2  2
        //  3(2) 0  1  2  2  3  3  3  3
        //  4(5) 0  1  2  2  3  13 14 15

        // 점화식
        // 배낭에 해당 무게 못담을 경우 (weightList.get(i) < j) - dp[i][j] = dp[i - 1][j]
        // 배낭에 해당 무게 담을 경우 (weightList.get(i) >= j) - dp[i][j] = Math.max(dp[i - 1][j - weight] + value, dp[i - 1][j])

        // weightList - 3, 4, 5, 6
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= maxWeight; j++) {
                int itemWeight = itemList.get(i - 1).weight;
                int itemValue = itemList.get(i - 1).value;

                if (itemWeight > j) { // 배낭에 해당 무게를 담지 못함
                    dp[i][j] = dp[i - 1][j];
                } else { // 배낭에 해당 무게가 담김
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - itemWeight] + itemValue);
                }
            }
        }

        System.out.println(dp[itemList.size()][maxWeight]);
    }

    public class Item implements Comparable<Item> {
        int weight;
        int value;

        public Item(int w, int v) {
            this.weight = w;
            this.value = v;
        }

        @Override
        public int compareTo(Item o) {
            return this.weight == o.weight ? this.value - o.value : this.weight - o.weight;
        }
    }
}
