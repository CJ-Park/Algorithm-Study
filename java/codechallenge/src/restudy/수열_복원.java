package restudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
72점 나옴
내일 답안 보고 뭐가 문젠지 확인
 */
public class 수열_복원 {
    int n;
    List<Integer> removeList = new ArrayList<>();
    Set<Integer> result = new HashSet<>();

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());

        List<Integer> list = new ArrayList<>();
        String[] nums = br.readLine().split(" ");

        for (String num : nums) {
            list.add(Integer.parseInt(num));
        }

        Collections.sort(list);

        list.remove(0);
        removeList.add(0);

        while (!list.isEmpty()) {
            List<Integer> remove = new ArrayList<>();
            int first = list.get(0);

            for (int before : removeList) {
                int target = first + before;

                if (list.contains(target)) {
                    list.remove(Integer.valueOf(target));
                    remove.add(target);
                    result.add(first);
                }
            }

            removeList.addAll(remove);
        }

        List<Integer> res = new ArrayList<>(result);
        Collections.sort(res);
        for (int r : res) {
            sb.append(r).append(" ");
        }

        System.out.print(sb);
    }

    /*
    100점 답안 - dfs 사용
     */

//    // 결과 저장
//    ArrayList<Long> res = new ArrayList<>();
//
//    // 부분집합의 합 저장
//    ArrayList<Long> now = new ArrayList<>();
//
//    public void solution_2() {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        ArrayList<Long> v = new ArrayList<>();
//
//        for (int i = 0; i < (1 << n); i++) {
//            long a = scanner.nextLong();
//            v.add(a);
//        }
//
//        Collections.sort(v);
//
//        for (int i = 1; i < v.size(); i++) {
//            if (!now.contains(v.get(i))) {
//                long m = v.get(i);
//                dfs(res, 0, 0, now, m);
//                res.add(v.get(i));
//            }
//            now.remove(v.get(i));
//        }
//
//        for (long nxt : res) {
//            System.out.print(nxt + " ");
//        }
//        System.out.println();
//    }
//
//    public void dfs(ArrayList<Long> res, int x, long sum_, ArrayList<Long> now, long m) {
//        if (x == res.size()) {
//            now.add(sum_ + m);
//            return;
//        }
//        dfs(res, x + 1, sum_, now, m);
//        dfs(res, x + 1, sum_ + res.get(x), now, m);
//    }
}
