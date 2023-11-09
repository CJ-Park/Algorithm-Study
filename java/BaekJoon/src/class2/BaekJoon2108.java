package class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 통계학
public class BaekJoon2108 {
    int n;
    ArrayList<Integer> list;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }

        list.sort(Comparator.naturalOrder());

        firstCase();
        secondCase();
        thirdCase();
        fourthCase();
    }

    public void firstCase() {
        int sum = 0;
        for (int num : list) {
            sum += num;
        }
        int res = Math.toIntExact(Math.round(sum / (list.size() * 10 / 10.0)));
        System.out.println(res);
    }

    public void secondCase() {
        int mid = list.size() / 2;
        System.out.println(list.get(mid));
    }

    // 가장 많이 나타난 값 출력
    // 최빈값이 여러개면 두번째로 작은 값 출력
    public void thirdCase() {
        Map<Integer, Integer> map = new HashMap<>();
        int maxCount = 0;
        List<Integer> maxNumList = new ArrayList<>();
        for (int idx : list) {
            if (map.get(idx) != null) {
                map.put(idx, (map.get(idx) + 1));
            } else {
                map.put(idx, 1);
            }
        }

        for (int num : map.keySet()) {
            if (map.get(num) > maxCount) {
                maxCount = map.get(num);
                maxNumList.clear();
                maxNumList.add(num);
            } else if (map.get(num) == maxCount) {
                maxNumList.add(num);
            }
        }

        if (maxNumList.size() == 1) {
            System.out.println(maxNumList.get(0));
        } else {
            maxNumList.sort(Comparator.naturalOrder());
            System.out.println(maxNumList.get(1));
        }
    }

    public void fourthCase() {
        int res = list.get(list.size() - 1) - list.get(0);
        System.out.println(res);
    }
}
