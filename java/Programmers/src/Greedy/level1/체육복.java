package Greedy.level1;

import java.util.*;

public class 체육복 {
    public int solution(int n, int[] lost, int[] reserve) {
        int count = 0;
        boolean[] student = new boolean[n];
        Arrays.fill(student, true);
        Arrays.sort(lost);

        Map<Integer, Boolean> map = new HashMap<>();
        for (int r : reserve) {
            map.put(r - 1, true);
        }

        for (int lostPerson : lost) {
            student[lostPerson - 1] = false;
        }

        for (int key : map.keySet()) {
            if (!student[key]) {
                student[key] = true;
                map.put(key, false);
            }
        }

        for (int i = 0; i < n; i++) {
            if (!student[i]) { // 체육복 잃어버린 사람일 경우

                List<Integer> list = new ArrayList<>(map.keySet());
                Collections.sort(list);

                // 이전 사람과 다음 사람에게 여분 체육복 확인
                for (int reserver : list) {

                    if (map.get(reserver)) {
                        if (i - 1 == reserver || i + 1 == reserver) {
                            student[i] = true;
                            map.put(reserver, false);
                            break;
                        }
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (student[i]) {
                count++;
            }
        }

        return count;
    }
}
