package Hash.level1;

import java.util.*;

public class 폰켓몬 {
    public int solution(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int max = nums.length / 2;

        max = Math.min(set.size(), max);

        return max;
    }
}
