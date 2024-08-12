package level2;

/*
2023 카카오 블라인드
중복수열 + 완전탐색
 */
public class 이모티콘_할인행사 {
    private final int[] sales = { 10, 20, 30, 40 };
    private final int[] result = { 0, 0 };
    private int[][] userInfo;

    public int[] solution(int[][] users, int[] emoticons) {
        userInfo = users;
        recur(0, new int[emoticons.length], emoticons);

        return result;
    }

    // 중복수열 구현
    private void recur(int count, int[] saleList, int[] emoticons) {
        if (count == saleList.length) { // 수열 완성 시 check
            check(saleList, emoticons);
            return;
        }

        for (int i = 0; i < sales.length; i++) {
            saleList[count] = sales[i];
            recur(count + 1, saleList, emoticons);
        }
    }

    private void check(int[] saleList, int[] emoticons) {
        int membership = 0;
        int total = 0;

        for (int[] user : userInfo) {
            int rate = user[0];
            int cutLine = user[1];
            int totalPrice = 0;

            for (int i = 0; i < saleList.length; i++) {
                if (saleList[i] >= rate) { // 구매 확정
                    int price =
                            (int)(emoticons[i] - emoticons[i] * saleList[i] / 100.0);
                    totalPrice += price;

                    if (totalPrice >= cutLine) {
                        totalPrice = 0;
                        membership++;
                        break;
                    }
                }
            }

            total += totalPrice;
        }

        if (result[0] == membership && result[1] < total) {
            result[1] = total;
        }

        if (result[0] < membership) {
            result[0] = membership;
            result[1] = total;
        }
    }
}
