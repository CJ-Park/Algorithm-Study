package level3;

import java.util.HashMap;
import java.util.Map;

public class 다단계_칫솔_판매 {
    int[] result;
    Map<String, Integer> profitMap = new HashMap<>();;
    Map<String, String> parentMap = new HashMap<>();;

    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        result = new int[enroll.length];

        for (int i = 0; i < enroll.length; i++) {
            String child = enroll[i];
            String parent = referral[i];

            parentMap.put(child, parent);
            profitMap.put(child, 0);
        }

        for (int i = 0; i < seller.length; i++) {
            String sellerName = seller[i];
            int price = amount[i] * 100;
            takeProfit(sellerName, price);
        }

        for (int i = 0; i < enroll.length; i++) {
            String name = enroll[i];
            int profit = profitMap.get(name);

            result[i] = profit;
        }

        return result;
    }

    private void takeProfit(String name, int price) {
        // 이득 없으면 리턴
        if (price == 0) {
            return;
        }

        int left = price / 10;
        int myProfit = price - left;

        // 본인 이득 계산
        profitMap.put(name, profitMap.get(name) + myProfit);

        String parent = parentMap.get(name);

        // 부모가 민호일 경우 리턴
        if (parent.equals("-")) {
            return;
        }
        // 아니면 부모 이득 계산
        takeProfit(parent, left);
    }
}
