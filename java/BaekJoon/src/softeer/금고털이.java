package softeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class 금고털이 {
    int n, w, dp, weightSum;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m, p;
        List<Item> itemList = new ArrayList<>();
        w = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        // 금속 itemList 에 저장
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            p = Integer.parseInt(st.nextToken());
            Item item = new Item(m, p);
            itemList.add(item);
        }
        // 무게 당 가격순으로 정렬
        Collections.sort(itemList);

        for (int i = 0; i < n; i++) {
            weightSum += itemList.get(i).weight;
            // 무게 합이 n보다 작거나 같을 경우 -> 모든 가격 계산 후 dp에 추가
            if (weightSum <= w) {
                dp += itemList.get(i).price * itemList.get(i).weight;
            } else { // 무게 합이 가방보다 크다 -> 나머지 부분만 계산해서 dp에 추가
                dp += itemList.get(i).price * (itemList.get(i).weight - (weightSum - w));
                break;
            }
        }
        System.out.println(dp);
    }

    public class Item implements Comparable<Item> {
        int weight;
        int price;

        public Item (int w, int p) {
            this.weight = w;
            this.price = p;
        }

        @Override
        public int compareTo(Item o) {
            return Integer.compare(o.price, this.price);
        }
    }
}
