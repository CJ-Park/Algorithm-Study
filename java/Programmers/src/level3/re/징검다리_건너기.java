package level3.re;

import java.util.Arrays;

// 2019 카카오 인턴십
public class 징검다리_건너기 {
    public int solution(int[] stones, int k) {
        int result = 0;
        int[] arr = new int[stones.length];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = stones[i];
        }

        Arrays.sort(arr);

        int low = arr[0];
        int top = arr[arr.length - 1];

        // 시간복잡도 O(n^2) 은 불가능하므로 이진탐색으로 진행
        while (low <= top) {
            int mid = (low + top) / 2;
            int count = 0;

            for (int stone : stones) {
                if (stone - mid <= 0) {
                    count++;
                } else {
                    count = 0;
                }

                if (count == k) {
                    result = mid;
                    break;
                }
            }

            if (count < k) { // 사람을 더 보내야됨 => mid 값 증가 필요
                low = mid + 1;
            } else { // 사람을 줄여야됨 => mid 값 감소 필요
                top = mid - 1;
            }
        }

        return result;
    }
}
